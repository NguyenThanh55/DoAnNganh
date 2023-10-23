/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.repository.impl;

import com.myproject.pojo.Comment;
import com.myproject.pojo.Question;
import com.myproject.repository.QuestionRepository;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.text.html.HTMLDocument;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Thanh
 */
@Repository
@Transactional
public class QuestionRepositoryImpl implements QuestionRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

    @Override
    public Question addOrUpdateQuestion(Question q) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (q.getId() == null) {
                if (q.getStyle() == 1) {
                    Question ques = this.getQuestionById(q.getAnswer());
                    ques.setAnswer(1);
                    s.update(ques);
                }
                s.save(q);
                System.out.println("Add success!!");
            } else {
                s.update(q);
                System.out.println("Update success!!");
            }
            return q;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Object> getListQuestionsByLive(int liveId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        List<Predicate> predicates = new ArrayList<>();
        Root rQuestion = q.from(Question.class);
        q.select(rQuestion);

        Predicate p = b.equal(rQuestion.get("livestreamId"), liveId);
        predicates.add(p);
        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean deleteQuestion(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Question c = this.getQuestionById(id);
        try {
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Question getQuestionById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Question.class, id);
    }

    @Override
    public List<Object> getQuestionByAnswer(int answer) {
        Session s = this.factory.getObject().openSession();
        Query q = s.createQuery("FROM Question where answer = :answer");
        q.setParameter("answer", answer);
        return q.getResultList();
    }

    @Override
    public List<Object> getListQuestionsForQuestion(Map<String, String> params) {
        Session s = this.factory.getObject().openSession();
//        Query q = s.createQuery("FROM Question");
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Question> q = b.createQuery(Question.class);

        Root<Question> root = q.from(Question.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.isNull(root.get("livestreamId")));
        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page == null) {
                page = "1";
            }
            if (!page.equals("0")) {
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_QUESTION_SIZE"));
                query.setFirstResult((Integer.parseInt(page) - 1) * 10);
                query.setMaxResults(pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public Long countQuetionsNotLive() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Long> q = b.createQuery(Long.class);

        Root r = q.from(Question.class);

        List<Predicate> predicates = new ArrayList<>();

        predicates.add(b.isNull(r.get("livestreamId")));
        predicates.add(b.equal(r.get("style"), 1));
        q.select(b.count(r)).where(predicates.toArray(new Predicate[0]));

        long count = session.createQuery(q).uniqueResult();
        return count;
    }

    @Override
    public List<Question> getQuestions(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Question> q = b.createQuery(Question.class);
        Root root = q.from(Question.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String livestreamId = params.get("livestreamId");
            if (livestreamId != null && !livestreamId.isEmpty()) {
                predicates.add(b.equal(root.get("livestreamId"), Integer.parseInt(livestreamId)));
            }

            q.where(predicates.toArray(Predicate[]::new));
        }
        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page == null) {
                page = "1";
            }
            if (!page.equals("0")) {
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_QUESTION_SIZE"));
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public List<Object> getQuestionForLive(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Question> q = b.createQuery(Question.class);
        Root root = q.from(Question.class);
        q.select(root);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.isNotNull(root.get("livestreamId")));
        q.where(predicates.toArray(Predicate[]::new));

        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);

        if (params != null) {
            String page = params.get("page");
            if (page == null) {
                page = "1";
            }
            if (!page.equals("0")) {
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_QUESTION_SIZE"));
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }

        return query.getResultList();
    }
}
