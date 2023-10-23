/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.myproject.pojo.Banner;
import com.myproject.service.BannerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin
public class ApiBannerController {
    @Autowired
    private BannerService bannerService;
    
    @DeleteMapping("/admin/banner/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBanner(@PathVariable(value = "id") int id) {
        this.bannerService.deleteBanner(id);
    }
    
    @GetMapping("/listBanner")
    public ResponseEntity<List<Banner>> listDepart() {
        List<Banner> banners = this.bannerService.getBannersApi();
        return new ResponseEntity<>(banners,HttpStatus.OK);
    }
}
