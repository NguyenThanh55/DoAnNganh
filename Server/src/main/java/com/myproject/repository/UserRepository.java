/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.repository;

import com.myproject.pojo.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author vbmho
 */
public interface UserRepository {

    List<User> getUsers();

    Object getUserById(int id);

    boolean addUser(User user);

    List<User> getUser(String username);

    boolean updateUser(User user);

    boolean deleteUser(int id);
    
    int countUsers();
    
    User getUserByUsername(String username);
    
    boolean authUser(String username, String password);
    
    User addUserAPI(User user);
    
    User registerUserGoogle(Map<String, String> params);
    
    User getUserByEmail(String mail);
}
