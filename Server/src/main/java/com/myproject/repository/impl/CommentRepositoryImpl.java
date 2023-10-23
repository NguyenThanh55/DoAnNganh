/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.repository.impl;

import com.myproject.pojo.Comment;
import com.myproject.pojo.Post;
import com.myproject.repository.CommentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
public class CommentRepositoryImpl implements CommentRepository{
    @Autowired
    LocalSessionFactoryBean factory;
    @Autowired
    private Environment env;
    
    @Override
    public List<Object> getComments() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Comment");
        return q.getResultList();
    }
    
    @Override
    public List<Object> getCommentByPost(int postId) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        List<Predicate> predicates = new ArrayList<>();
        Root rComment = q.from(Comment.class);
        q.select(rComment);

        Predicate p = b.equal(rComment.get("postId"), postId);
        predicates.add(p);
        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public Comment addOrUpdateComment(Comment comment) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (comment.getId() == null) {
                s.save(comment);
                System.out.println("Add success!!");
            } else {
                s.update(comment);
                System.out.println("Update success!!");
            }
            return comment;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Object> getCommentByReply(int reply) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);
        List<Predicate> predicates = new ArrayList<>();
        Root rComment = q.from(Comment.class);
        q.select(rComment);

        Predicate p = b.equal(rComment.get("reply"), reply);
        predicates.add(p);
        q.where(predicates.toArray(Predicate[]::new));

        Query query = s.createQuery(q);
        return query.getResultList();
//        Query q = s.createQuery("FROM Comment where reply = :reply");
//        q.setParameter("reply", reply);
//        return query.getResultList();
    }
    
    @Override
    public Comment getCommentById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Comment.class, id);
    }

    @Override
    public boolean deleteComment(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Comment c = this.getCommentById(id);
        List<Object> list = getCommentByReply(id);
        try {
            list.forEach(action -> {s.delete(action);});
            s.delete(c);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Comment> getComments(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Comment> q = b.createQuery(Comment.class);
        Root root = q.from(Comment.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String postId = params.get("postId");
            if (postId != null && !postId.isEmpty()) {
                predicates.add(b.equal(root.get("postId"), Integer.parseInt(postId)));
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
                int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
                query.setFirstResult((Integer.parseInt(page) - 1) * pageSize);
                query.setMaxResults(pageSize);
            }
        }

        return query.getResultList();
    }

    @Override
    public long countComment() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Long> q = b.createQuery(Long.class);

        Root r = q.from(Comment.class);
        q.select(b.count(r));

        long count = session.createQuery(q).uniqueResult();
        return count;
    }
    
}
