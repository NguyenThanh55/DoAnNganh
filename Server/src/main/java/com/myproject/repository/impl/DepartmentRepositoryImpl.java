/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.repository.impl;

import com.myproject.pojo.Department;
import com.myproject.pojo.Post;
import com.myproject.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.CacheMode;
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
public class DepartmentRepositoryImpl implements DepartmentRepository {

    @Autowired
    LocalSessionFactoryBean factory;

    @Autowired
    private Environment env;

    @Override
    public List<Object> getDepartment() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Department");

        return q.getResultList();
    }

    @Override
    public Object getDepartmentById(int i) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM Department WHERE id= :i");
        q.setParameter("i", i);
        return q.getSingleResult();
    }

    @Override
    public boolean addOrUpdateDepartment(Department d) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            if (d.getId() == null) {
                s.save(d);
            } else {
                s.update(d);
            }
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteDepartment(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        Department d = this.getDepartmentById_admin(id);
        try {
            s.delete(d);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public Department getDepartmentById_admin(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(Department.class, id);
    }

    @Override
    public List<Department> getDepartments(Map<String, String> params) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder b = s.getCriteriaBuilder();
        CriteriaQuery<Department> q = b.createQuery(Department.class);
        Root root = q.from(Department.class);
        q.select(root);

        if (params != null) {
            List<Predicate> predicates = new ArrayList<>();

            String kw = params.get("kw");
            if (kw != null && !kw.isEmpty()) {
                predicates.add(b.like(root.get("name"), String.format("%%%s%%", kw)));
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
    public int countDepartments() {

        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM Department");

        return Integer.parseInt(q.getSingleResult().toString());
    }

}
