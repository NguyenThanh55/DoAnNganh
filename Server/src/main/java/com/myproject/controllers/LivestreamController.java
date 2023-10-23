/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.cloudinary.utils.ObjectUtils;
import com.myproject.pojo.Department;
import com.myproject.pojo.Livestream;
import com.myproject.service.LiveStreamService;
import java.io.IOException;
import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Thanh
 */
@Controller
public class LivestreamController {

    @Autowired
    private LiveStreamService liveStreamService;

    @Autowired
    private Environment env;

    @Autowired
    private CustomDateEditor customDateEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, customDateEditor);
    }

    @GetMapping("/admin/livestreams")
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("livestreams", this.liveStreamService.getLivestreams(params));
        long count = this.liveStreamService.countLiveStreams();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(count * 1.0 / pageSize));

        return "livestream_admin";
    }

    @GetMapping("/admin/livestreams/add")
    public String list(Model model) {
        model.addAttribute("livestream", new Livestream());
        return "add_livestream";
    }

    @PostMapping("/admin/livestreams/add")
    public String add(Model model, @ModelAttribute(value = "livestream") Livestream l,
            BindingResult rs) {
        String errMsg = "";
        if (!rs.hasErrors()) {
            if (this.liveStreamService.addLive(l) == true) {
                return "redirect:/admin/livestreams";
            } else {
                errMsg = "Đã có lỗi xảy ra !!!";
            }
        } else {
            errMsg = "Đã có lỗi xảy ra !!!";
        }

        model.addAttribute(
                "errMsg", errMsg);

        return "add_livestream";
    }
    
    @GetMapping("/admin/livestreams/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("livestream", this.liveStreamService.getLiveById(id));
        return "add_livestream";
    }
}
