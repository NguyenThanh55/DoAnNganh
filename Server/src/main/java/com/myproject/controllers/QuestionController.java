/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.myproject.pojo.Livestream;
import com.myproject.pojo.Question;
import com.myproject.service.LiveStreamService;
import com.myproject.service.QuestionService;
import java.util.Map;
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
 * @author Thanh
 */
@Controller
public class QuestionController {
    
    @Autowired
    private QuestionService questionService;

    @Autowired
    private Environment env;
   
    @GetMapping("/admin/questions")
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("questions", this.questionService.getQuestions(params));
        int count = this.questionService.getQuestions(null).size();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_QUESTION_SIZE"));
        model.addAttribute("pages", Math.ceil(count * 1.0 / pageSize));

        return "question_admin";
    }
    
}
