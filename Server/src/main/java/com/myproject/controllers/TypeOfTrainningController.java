/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.myproject.pojo.Post;
import com.myproject.pojo.Typeoftrainning;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author vbmho
 */
@Controller
public class TypeOfTrainningController {
    @Autowired
    private TypeOfTrainningService typeService;
    @Autowired
    private Environment env;
    
    
    @GetMapping("/admin/typeoftrainnings")
    public String index(Model model) {
        model.addAttribute("types", this.typeService.getTypeOfTrainning());
        return "typeoftrainning_admin";
    }
    
    @GetMapping("/admin/typeoftrainnings/add")
    public String list(Model model) {
        model.addAttribute("totn", new Typeoftrainning());
        return "add_totn";
    }
    
    @PostMapping("/admin/typeoftrainnings/add")
    public String add(Model model ,@ModelAttribute(value = "typeoftrainning") Typeoftrainning t,
            BindingResult rs) {
        String errMsg = "";
        if (!rs.hasErrors()){
            if (this.typeService.addOrUpdateTOTN(t) == true)
                return "redirect:/admin/typeoftrainnings";
            else 
                errMsg = "Đã có lỗi xảy ra !!!";
        }
        else {
            errMsg = "Đã có lỗi xảy ra !!!";
        }
            
        model.addAttribute("errMsg", errMsg);
        return "add_totn";
    }
    
    @GetMapping("/admin/typeoftrainnings/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("totn", this.typeService.getTOTNById(id));
        return "add_totn";
    }
}
