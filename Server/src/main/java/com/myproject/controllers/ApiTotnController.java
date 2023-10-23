/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.myproject.service.TypeOfTrainningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vbmho
 */
@RestController
@RequestMapping("/api")
public class ApiTotnController {
    @Autowired
    private TypeOfTrainningService typeService;
    
    @DeleteMapping("/admin/typeoftrainnings/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTypeOfTrainning(@PathVariable(value = "id") int id) {
        this.typeService.deleteTOTN(id);
    }
}