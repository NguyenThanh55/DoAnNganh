/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.service.impl;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.myproject.pojo.User;
import com.myproject.repository.UserRepository;
import com.myproject.service.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vbmho
 */
@Service("userDetailsService")
public class UserServiceImpl implements UserService{

    @Autowired
    private LocalSessionFactoryBean factory;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    
    @Autowired
    private Cloudinary cloudinary;
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public Object getUserById(int id) {
        return this.userRepository.getUserById(id);
    }

    @Override
    public boolean addUser(User user) {
        String pass = user.getPassword();
        
        user.setActive(Boolean.TRUE);
        user.setUserRole(User.USER);
        user.setPassword(this.passwordEncoder.encode(pass));
                
        return this.userRepository.addUser(user);
    }

    @Override
    public List<User> getUsers(String name) {
        return this.userRepository.getUser(name);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        List<User> users = this.getUsers(name);
        if (users.isEmpty())
            throw new UsernameNotFoundException("User does not exist!!!");
        
        User u = users.get(0);
        
        Set<GrantedAuthority> auth = new HashSet<>();
        auth.add(new SimpleGrantedAuthority(u.getUserRole()));
        return new org.springframework.security.core.userdetails.User(u.getUsername(),
                u.getPassword(), auth);
    }

    @Override
    public boolean updateUser(User user) {
        user.setActive(Boolean.TRUE);
        return this.userRepository.updateUser(user);
    }
    
    

    @Override
    public boolean deleteUser(int id) {
        return this.userRepository.deleteUser(id);
    }

    @Override
    public int countUsers() {
        return this.userRepository.countUsers();
    }

    @Override
    public boolean addUserByAdmin(User user) {
        String pass = user.getPassword();
        
        user.setActive(Boolean.TRUE);
        user.setPassword(this.passwordEncoder.encode(pass));
                
        return this.userRepository.addUser(user);
    }

    @Override
    public List<String> roles() {
        List<String> roles = new ArrayList();
        roles.add("ADMIN");
        roles.add("USER");
        roles.add("CONSULTANT");
        return roles;
    }

    @Override
    public User getUserByUserName(String username) {
        return this.userRepository.getUserByUsername(username);
    }

    @Override
    public boolean authUser(String username, String password) {
        return this.userRepository.authUser(username, password);
    }

    @Override
    public User addUserAPI(Map<String, String> params, MultipartFile avatar) {
        User u = new User();
        u.setFirstName(params.get("firstName"));
        u.setLastName(params.get("lastName"));
        u.setPhone(params.get("phone"));
        u.setEmail(params.get("email"));
        u.setUsername(params.get("username"));
        u.setPassword(this.passwordEncoder.encode(params.get("password")));
        u.setUserRole("USER");
        u.setActive(Boolean.TRUE);
//        u.setAvatar("https://res.cloudinary.com/dohcsyfoi/image/upload/v1692291532/qys1zulsigtbq9mtm3gn.jpg");
        if (!avatar.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(avatar.getBytes(), 
                        ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.userRepository.addUserAPI(u);
        return u;
    }

    @Override
    public User changePassword(Map<String, String> params) {
//        User u = this.userRepository.getUserByUserName(params.get("username").toString());
        User u = this.userRepository.getUserByUsername(params.get("username").toString());
        String pass = params.get("newPassword").toString();
        u.setPassword(this.passwordEncoder.encode(pass));
        if (this.updateUser(u) == true)
            return u;
        return null;
    }
    
    @Override
    public User registerUserGoogle(Map<String, String> params) {
        if(this.userRepository.getUserByUsername(params.get("username"))== null){
            return this.userRepository.registerUserGoogle(params);
        }else{
            return this.userRepository.getUserByUsername(params.get("username"));
        }
        
    }

    @Override
    public User getUserByEmail(String mail) {
        return this.userRepository.getUserByEmail(mail);
    }
    
    
}
