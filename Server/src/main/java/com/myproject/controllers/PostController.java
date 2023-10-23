/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.myproject.pojo.Post;
import com.myproject.service.CategoryService;
import com.myproject.service.PostService;
import com.myproject.service.TypeOfTrainningService;
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
 * @author Thanh
 */
@Controller
public class PostController {
    @Autowired
    private PostService postService;
    
    @Autowired
    private CategoryService cateService;
    
    @Autowired
    private TypeOfTrainningService typeService;
    @Autowired
    private Environment env;
    
    @ModelAttribute
    public void commonAttr(Model model) {
       model.addAttribute("types", this.typeService.getTypeOfTrainning());
    }
    
    @RequestMapping("/post_info")
    public String postInfo(Model model, @RequestParam Map<String, String> params) {
        int id = Integer.parseInt(params.get("postId").toString());
        model.addAttribute("post", this.postService.getPostById(id));
        return "post_info";
    }
    
    
    @GetMapping("/admin/post")
    public String index(Model model, @RequestParam Map<String, String> params) {
        String typeOfTrainningId = params.get("typeOfTrainningId");
        if (typeOfTrainningId != null ) {
            model.addAttribute("typeOfTrainningId",typeOfTrainningId );
        }
        model.addAttribute("posts", this.postService.getPosts(params));
        long count = this.postService.countPosts();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(count*1.0/pageSize));
        
        return "post";
    }
    
    @GetMapping("/admin/post/add")
    public String list(Model model) {
        model.addAttribute("post", new Post());
        return "add_post";
    }
    
    @PostMapping("/admin/post/add")
    public String add(Model model ,@ModelAttribute(value = "post") Post p,
            BindingResult rs) {
        String errMsg = "";
        if (!rs.hasErrors()){
            if (this.postService.addOrUpdatePost(p) == true)
                return "redirect:/admin/post";
            else 
                errMsg = "Đã có lỗi xảy ra !!!";
        }
        else {
            errMsg = "Đã có lỗi xảy ra !!!";
        }
            
        model.addAttribute("errMsg", errMsg);
        return "add_post";
    }
    
    @GetMapping("/admin/post/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("post", this.postService.getPostById(id));
        return "add_post";
    }
    
    
}
