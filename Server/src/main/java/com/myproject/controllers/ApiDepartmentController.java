
package com.myproject.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Thanh
 */
import com.myproject.pojo.Department;
import com.myproject.pojo.Post;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vbmho
 */
@RestController
@RequestMapping("/api/departments")
@CrossOrigin
public class ApiDepartmentController {
    @Autowired
    private DepartmentService departmentService;
    
    @DeleteMapping("/admin/departments/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable(value = "id") int id) {
        this.departmentService.deleteDepartment(id);
    }
    
    @GetMapping("/listDepartment")
    public ResponseEntity<List<Object>> listDepart() {
        List<Object> departs = this.departmentService.getDepartment();
        return new ResponseEntity<>(departs,HttpStatus.OK);
    }
   
    @RequestMapping("/department_info/{id}")
    public Object departInfo(Model model, @RequestParam Map<String, String> params,
            @PathVariable(value = "id") int id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String i = String.valueOf(id);
        Object p = this.departmentService.getDepartmentById(id);
        Object departJson = objectMapper.writeValueAsString(p);
        return new ResponseEntity<>(departJson, HttpStatus.OK);
    }
    
    
}

