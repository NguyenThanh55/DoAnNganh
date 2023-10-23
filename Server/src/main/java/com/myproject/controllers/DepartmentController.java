/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.myproject.pojo.Department;
import com.myproject.pojo.Post;
import com.myproject.service.DepartmentService;
import com.myproject.service.TypeOfTrainningService;
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
 * @author Thanh
 */
@Controller
@ControllerAdvice
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private TypeOfTrainningService typeService;
    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private Environment env;

    @RequestMapping("/department_info")
    public String departmentInfo(Model model, @RequestParam Map<String, String> params) {
        String id = params.get("departId").toString();
        model.addAttribute("department", this.departmentService.getDepartmentById(Integer.parseInt(id)));
        return "department_info";
    }

    //Admin
    @ModelAttribute
    public void commonAttr(Model model) {
        model.addAttribute("types", this.typeService.getTypeOfTrainning());
    }

    @GetMapping("/admin/departments")
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("departments", this.departmentService.getDepartments(params));
        int count = this.departmentService.countDepartments();
        int pageSize = Integer.parseInt(this.env.getProperty("PAGE_SIZE"));
        model.addAttribute("pages", Math.ceil(count * 1.0 / pageSize));

        return "department_admin";
    }

    @GetMapping("/admin/departments/add")
    public String list(Model model) {
        model.addAttribute("department", new Department());
        return "add_department";
    }

    @PostMapping("/admin/departments/add")
    public String add(Model model, @ModelAttribute(value = "department") Department d,
            BindingResult rs) {
        String errMsg = "";
        if (!rs.hasErrors()) {
            try {
                Map r = this.cloudinary.uploader().upload(d.getFile().getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                String intro = (String) r.get("secure_url");
                d.setIntroduceVideo(intro);
                if (this.departmentService.addOrUpdateDepartment(d) == true) {
                    return "redirect:/admin/departments";
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
        return "add_department";
    }

    @GetMapping("/admin/departments/add/{id}")
    public String update(Model model, @PathVariable(value = "id") int id) {
        model.addAttribute("department", this.departmentService.getDepartmentById(id));
        return "add_department";
    }
}
