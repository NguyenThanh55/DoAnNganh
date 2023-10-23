/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.repository.impl;

import com.myproject.pojo.User;
import com.myproject.repository.UserRepository;
import java.util.List;
import java.util.Map;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vbmho
 */
@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    LocalSessionFactoryBean factory;

    @Autowired
    private BCryptPasswordEncoder passEncoder;

    @Override
    public List<User> getUsers() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User");

        return q.getResultList();

    }

    @Override
    public User getUserById(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        return s.get(User.class, id);
    }

    @Override
    public boolean addUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(user);
            return true;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<User> getUser(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<User> q = builder.createQuery(User.class);
        Root rUser = q.from(User.class);
        q = q.select(rUser);

        if (!username.isEmpty()) {
            Predicate p = builder.equal(rUser.get("username").as(String.class), username.trim());
            q = q.where(p);
        }

        Query query = s.createQuery(q);
        return query.getResultList();
    }

    @Override
    public boolean updateUser(User user) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.update(user);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        Session s = this.factory.getObject().getCurrentSession();
        User u = this.getUserById(id);
        try {
            s.delete(u);
            return true;
        } catch (HibernateException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public int countUsers() {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("SELECT COUNT(*) FROM User");

        return Integer.parseInt(q.getSingleResult().toString());
    }

    @Override
    public User getUserByUsername(String username) {
        Session s = this.factory.getObject().getCurrentSession();
        Query q = s.createQuery("FROM User WHERE username=:un");
        q.setParameter("un", username);
        try {
            User u = (User) q.getSingleResult();
            return u;
        } catch (NoResultException nre) {
            return null;
        }

    }

    @Override
    public boolean authUser(String username, String password) {
        User u = this.getUserByUsername(username);
        return this.passEncoder.matches(password, u.getPassword());
    }

    @Override
    public User addUserAPI(User u) {
        Session s = this.factory.getObject().getCurrentSession();
        try {
            s.save(u);
            System.out.println("Add success!!");
            return u;
        } catch (HibernateException ex) {
            ex.printStackTrace();
            return u;
        }
    }

    @Override
    public User registerUserGoogle(Map<String, String> params) {
        User u = new User();
        u.setFirstName(params.get("firstname"));
        u.setLastName(params.get("lastname"));
        u.setPhone("0976543210");
        u.setEmail(params.get("email"));
        String name = u.getFirstName() + u.getLastName();
        u.setUsername(name);
        u.setPassword(this.passEncoder.encode("123456"));
        u.setUserRole("USER");
        u.setActive(Boolean.TRUE);
        u.setAvatar(params.get("avatar"));
        this.addUserAPI(u);
        return u;
    }
    
    @Override
    public User getUserByEmail(String mail) {
        Session session = this.factory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<User> query = builder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        query.where(builder.and(builder.equal(root.get("email"), mail)));
        Query q = session.createQuery(query);
        List<User> results = q.getResultList();
        return results.isEmpty() ? null : results.get(0);
    }
}
