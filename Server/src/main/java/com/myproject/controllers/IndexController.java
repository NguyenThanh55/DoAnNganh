/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.myproject.pojo.Typeoftrainning;
import com.myproject.service.DepartmentService;
import com.myproject.service.PostService;
import com.myproject.service.TypeOfTrainningService;
import com.myproject.service.UserService;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Thanh
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class IndexController {
    @Autowired
    private TypeOfTrainningService typeService;
    @Autowired
    private PostService postService;
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private Environment env;
    
    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("types", this.typeService.getTypeOfTrainning());
        model.addAttribute("post_1", this.postService.get5PostByType(1));
        model.addAttribute("post_2", this.postService.get5PostByType(2));
        model.addAttribute("post_3", this.postService.get5PostByType(3));
        model.addAttribute("post_4", this.postService.get5PostByType(4));
        model.addAttribute("post_5", this.postService.get5PostByType(5));
        return "index";
    }
    
    @RequestMapping("/departments")
    public String department(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("departments", this.departmentService.getDepartment());
        return "department";
    }
    
    @RequestMapping("/post_index")
    public String postIndex(Model model, @RequestParam Map<String, String> params) {
        int id = Integer.parseInt(params.get("typeoftrainningId").toString());
        model.addAttribute("posts", this.postService.getPostByType(id, params));
        return "post_index";
    }
   
}
