/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.service;

import com.myproject.pojo.User;
import java.util.List;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vbmho
 */
public interface UserService extends UserDetailsService {

    List<User> getUsers();

    boolean addUser(User user);

    List<User> getUsers(String name);

    Object getUserById(int id);

    boolean updateUser(User user);
    
    User changePassword(Map<String, String> params);

    boolean deleteUser(int id);
    
    int countUsers();
    
    boolean addUserByAdmin(User user);
    
    List<String> roles();
    
    User getUserByUserName(String username);
    
    boolean authUser(String username, String password);
    
    User addUserAPI(Map<String, String> params, MultipartFile avatar);
    
    User registerUserGoogle(Map<String, String> params);
    
    User getUserByEmail(String mail);
}
