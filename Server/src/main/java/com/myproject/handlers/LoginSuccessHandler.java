/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.handlers;


import com.myproject.pojo.User;
import com.myproject.service.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
/**
 *
 * @author vbmho
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        List<User> users = this.userService.getUsers(a.getName());
        User u = users.get(0);
        
        request.getSession().setAttribute("currentUser", u);
        if (u.getUserRole().equals("ADMIN")) {
            response.sendRedirect(String.format("%s/admin/index", request.getContextPath()));
        }
        else {
            response.sendRedirect(request.getContextPath());
        }
    }
    
}
