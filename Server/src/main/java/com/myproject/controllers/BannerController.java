/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;
import com.myproject.pojo.Banner;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.myproject.service.BannerService;
import java.io.IOException;
import java.util.Map;
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
/**
 *
 * @author vbmho
 */
@Controller
public class BannerController {
    
    @Autowired
    private BannerService bannerService;
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private Environment env;
    
//    @ModelAttribute
//    public void commonAttr(Model model) {
//        model.addAttribute("types", this.typeService.getTypeOfTrainning());
//    }

    @GetMapping("/admin/banners")
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("banners", this.bannerService.getBanners(params));
        int count = this.bannerService.countBanners();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(count * 1.0 / pageSize));

        return "banner";
    }

    @GetMapping("/admin/banners/add")
    public String list(Model model) {
        model.addAttribute("banner", new Banner());
        return "add_banner";
    }

    @PostMapping("/admin/banners/add")
    public String add(Model model, @ModelAttribute(value = "banner") Banner b,
            BindingResult rs) {
        String errMsg = "";
        if (!rs.hasErrors()) {
            try {
                if(b.getFile() != null) {
                    Map r = this.cloudinary.uploader().upload(b.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                    String src_banner = (String) r.get("secure_url");
                    b.setUrl(src_banner);
                }
                System.out.println("=========" + b.getUrl());
                if (this.bannerService.addOrUpdateBanner(b) == true) {
                    return "redirect:/admin/banners";
                } else {
                    errMsg = "Đã có lỗi xảy ra !!!";
                }
            } catch (IOException ex) {
                errMsg = "Đã có lỗi xảy ra !!!";
            }
        } else {
            errMsg = "Đã có lỗi xảy ra !!!";
        }

        model.addAttribute("errMsg", errMsg);
        return "add_banner";
    }

    @GetMapping("/admin/banners/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("banner", this.bannerService.getBannerById(id));
        return "add_banner";
    }
}
