/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.myproject.pojo.User;
import com.myproject.service.UserService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vbmho
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private Environment env;

    @Autowired
    private Cloudinary cloudinary;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("roles", this.userService.roles());
    }

    @GetMapping("/admin/user")
    public String index(Model model, @RequestParam(required = false) String username) {

        if (username != null) {
            model.addAttribute("users", this.userService.getUsers(username));
        } else {
            model.addAttribute("users", this.userService.getUsers());
        }
        int count = this.userService.countUsers();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(count * 1.0 / pageSize));

        return "user";
    }

    @GetMapping("/admin/user/register")
    public String list(Model model) {
        model.addAttribute("user", new User());
        return "register_admin";
    }

    @PostMapping("/admin/user/register")
    public String addUser(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult rs) {

        String errMsg = "";
        String sucMsg = "";

        rs.getFieldErrors()
                .forEach(e -> System.out.println(
                        "field: " + e.getField() + ", rejected value: " + e.getRejectedValue()));
        if (!rs.hasErrors()) {
                user.setAvatar("https://res.cloudinary.com/dohcsyfoi/image/upload/v1690968439/j993fbu6dekru6b4dqto.jpg");
                if (user.getId() == null) {
                    
                    if (this.userService.getUserByUserName(user.getUsername()) == null) {
                        if (this.userService.addUserByAdmin(user)) {
                            sucMsg = "Tạo tài khoản thành công";
                            model.addAttribute("sucMsg", sucMsg);
                            return "register_admin";
                        } else {

                            errMsg = "Đã có lỗi xảy ra !!!";
                        }
                    } else {
                        errMsg = "Tên tài khoản đã tồn tại !!!";
                    }
                    
                } else {
                    
                    if (this.userService.updateUser(user)) {
                        sucMsg = "Cập nhật tài khoản thành công";
                        model.addAttribute("sucMsg", sucMsg);
                        return "register_admin";
                    } else {
                       
                        errMsg = "Đã có lỗi xảy ra !!!";
                    }
                }
        } else {
            
            errMsg = "Đã có lỗi xảy ra !!!";
        }

        model.addAttribute("errMsg", errMsg);

        return "register_admin";
    }

    @GetMapping("/admin/user/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "register_admin";
    }

}
