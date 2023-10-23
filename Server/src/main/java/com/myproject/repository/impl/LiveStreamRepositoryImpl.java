/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.repository.impl;

import com.myproject.pojo.Department;
import com.myproject.pojo.Livestream;
import com.myproject.repository.LiveStreamRepository;
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
public class LiveStreamRepositoryImpl implements LiveStreamRepository{
    
    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private Environment env;
    
    @Override
    public List<Object> getLiveStreams() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Livestream");
        return q.getResultList();
    }

    @Override
    public Object getLiveById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Livestream WHERE id= :id");
        q.setParameter("id", id);
        return q.getSingleResult();
    }

    @Override
    public boolean addLive(Livestream l) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (l.getId() == null) {
                s.save(l);
            } else {
                s.update(l);
            }
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    @Override
    public List<Livestream> getLivestreams(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Livestream> q = b.createQuery(Livestream.class);
        Root root = q.from(Livestream.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("title"), String.format("%%%s%%", kw)));
            }

//            String typeOfTrainningId = params.get("typeOfTrainningId");
//            if (typeOfTrainningId != null && !typeOfTrainningId.isEmpty()) {
//                predicates.add(b.equal(root.get("typeoftrainningId"), Integer.parseInt(typeOfTrainningId)));
//            }

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
    public long countLiveStreams() {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Long> q = b.createQuery(Long.class);

        Root r = q.from(Livestream.class);
        q.select(b.count(r));

        long count = session.createQuery(q).uniqueResult();
        return count;
//        return Integer.parseInt(q.getSingleResult().toString());
    }
    
    @Override
    public boolean deleteLive(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Livestream d = (Livestream) this.getLiveById(id);
        try {
            s.delete(d);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
}
