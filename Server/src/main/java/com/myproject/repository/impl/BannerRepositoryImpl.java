/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.repository.impl;
import com.myproject.pojo.Banner;
import com.myproject.repository.BannerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vbmho
 */
@Repository
@Transactional
public class BannerRepositoryImpl implements BannerRepository{

     @Autowired
    LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;
    
    @Override
    public List<Banner> getBanners() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("From Banner");
        
        return q.getResultList();
    }

    @Override
    public boolean addOrUpdateBanner(Banner b) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (b.getId() == null) {
                s.save(b);
            } else {
                s.update(b);
            }
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public int countBanners() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Banner");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public List<Banner> getBanners(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Banner> q = b.createQuery(Banner.class);
        Root root = q.from(Banner.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("title"), String.format("%%%s%%", kw)));
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
    public Banner getBannerById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Banner.class, id);
    }

    @Override
    public boolean deleteBanner(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Banner b = this.getBannerById(id);
        try {
            s.delete(b);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }
 
    @Override
    public List<Banner> getBannersApi() {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Banner> q = b.createQuery(Banner.class);
        Root root = q.from(Banner.class);
        q.select(root);
        q.orderBy(b.desc(root.get("id")));

        Query query = s.createQuery(q);
        query.setMaxResults(3);
            

        return query.getResultList();
    }
}