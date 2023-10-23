/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.google.gson.Gson;
import com.myproject.pojo.Post;
import com.myproject.service.CategoryService;
import com.myproject.service.PostService;
import com.myproject.service.QuestionService;
import com.myproject.service.TypeOfTrainningService;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.format.DateTimeFormatter;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author vbmho
 */
@Controller
@ControllerAdvice
@PropertySource("classpath:configs.properties")
public class AdminController {

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService cateService;

    @Autowired
    private TypeOfTrainningService typeService;
    
    @Autowired
    private QuestionService quesService;
    
    @Autowired
    private Environment env;

    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("cates", this.cateService.getCates());
    }
    
    @GetMapping("/admin/setdate")
    public String getDate(Model model) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
            model.addAttribute("date", formatter.format(this.quesService.getDate()));
        return "date";
    }
    
    @PostMapping("/admin/setdate")
    public String setDate(HttpServletRequest request) {
        String d = request.getParameter("date");
        System.out.println(d);
        this.quesService.setDate(d);
        return "redirect:/admin/setdate";
    }

    @RequestMapping("/admin/index/cate")
    public String index(Model model, @RequestParam Map<String, String> params) {
        if (!params.isEmpty()) {
            int id = Integer.parseInt(params.get("cateId"));
            switch (id) {
                case 0://Index
                    return "redirect:/admin/index";
                case 1://Banner
                    return "redirect:/admin/banners";
                case 2://Department
                    return "redirect:/admin/departments";
                case 3://Post
                    return "redirect:/admin/post";
                case 4://Livestream
                    return "redirect:/admin/livestreams";
                case 5://Ask
                    return "redirect:/admin/questions";
                case 6://TypeOfTrainning
                    return "redirect:/admin/typeoftrainnings";
                case 7://User
                    return "redirect:/admin/user";
                case 8://Comment
                    return "redirect:/admin/comments";
                case 9://Date
                    return "redirect:/admin/setdate";
            }
        }
        return "index_admin";
    }
    
    @GetMapping("/admin/index")
    public String home(Model model) {
        List<Integer> posts = new ArrayList<>();
        posts.add(this.postService.getPostByType(1, null).size());
        posts.add(this.postService.getPostByType(2, null).size());
        posts.add(this.postService.getPostByType(3, null).size());
        posts.add(this.postService.getPostByType(4, null).size());
        posts.add(this.postService.getPostByType(5, null).size());
        model.addAttribute("postbytype", posts);
        return "index_admin";
    }
}
