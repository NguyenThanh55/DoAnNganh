/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;
import com.myproject.pojo.Comment;
import com.myproject.service.CommentService;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vbmho
 */
@Controller
public class CommentController {
    @Autowired
    private CommentService cmtService;
    
    @Autowired
    private Environment env;
    
    
    @GetMapping("/admin/comments")
    public String index(Model model, @RequestParam Map<String, String> params) {
        model.addAttribute("comments", this.cmtService.getComments(params));
        long count = this.cmtService.countComment();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(count*1.0/pageSize));
        
        return "comment";
    }
    
    @GetMapping("/admin/comments/add")
    public String list(Model model) {
        model.addAttribute("comment", new Comment());
        return "add_comment";
    }
    
    @PostMapping("/admin/comments/add")
    public String add(Model model ,@ModelAttribute(value = "comment") Comment c,
            BindingResult rs) {
        String errMsg = "";
        if (!rs.hasErrors()){
            if (this.cmtService.addOrUpdateComment(c) != null)
                return "redirect:/admin/comments";
            else 
                errMsg = "Đã có lỗi xảy ra !!!";
        }
        else {
            errMsg = "Đã có lỗi xảy ra !!!";
        }
            
        model.addAttribute("errMsg", errMsg);
        return "add_comment";
    }
    
    @GetMapping("/admin/comments/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("comment", this.cmtService.getCommentById(id));
        return "add_comment";
    }
}
