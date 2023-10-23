///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.myproject.controllers;
//
//import com.cloudinary.Cloudinary;
//import com.cloudinary.utils.ObjectUtils;
//import com.myproject.pojo.User;
//import com.myproject.service.UserService;
//import java.io.IOException;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
///**
// *
// * @author vbmho
// */
//@Controller
//public class RegisterController {
//
//    @Autowired
//    private UserService userDetailsService;
//
//    @Autowired
//    private Cloudinary cloudinary;
//
//    @GetMapping("/user/register")
//    public String list(Model model) {
//        model.addAttribute("user", new User());
//        return "register";
//    }
//
//    @PostMapping("/user/register")
//    public String addUser(Model model, @ModelAttribute(value = "user") @Valid User user, BindingResult rs) {
//
//        String errMsg = "";
//
//        if (user.getPassword().equalsIgnoreCase(user.getConfirmPassword())) {
//            if (!rs.hasErrors()) {
//                try {
//                    Map r = this.cloudinary.uploader().upload(user.getFile().getBytes(),
//                            ObjectUtils.asMap("resource_type", "auto"));
//                    String avatar = (String) r.get("secure_url");
//                    user.setAvatar(avatar);
//                    if (this.userDetailsService.addUser(user)) {
//                        return "redirect:/user/login";
//                    } else {
//                        errMsg = "Đã có lỗi xảy ra !!!";
//                    }
//                } catch (IOException ex) {
//                    System.err.println(ex.getMessage());
//                    errMsg = "Đã có lỗi xảy ra !!!";
//                }
//            } else {
//                errMsg = "Đã có lỗi xảy ra !!!";
//            }
//
//        } else {
//            errMsg = "Mật khẩu không khớp !!!";
//        }
//
//        model.addAttribute("errMsg", errMsg);
//        return "register";
//    }
//
//}
