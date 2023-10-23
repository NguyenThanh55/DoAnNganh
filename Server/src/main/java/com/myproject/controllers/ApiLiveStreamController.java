/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myproject.service.LiveStreamService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Thanh
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiLiveStreamController {
    
    @Autowired
    private LiveStreamService liveService;
    
    @GetMapping("/livestreams/")
    public ResponseEntity<List<Object>> getLiveStreams() {
        return new ResponseEntity<>(this.liveService.getLiveStreams(), HttpStatus.OK);
    }
    
    @RequestMapping("/live_info/{id}")
    public Object liveInfo(@PathVariable(value = "id") int id) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String i = String.valueOf(id);
        Object p = this.liveService.getLiveById(id);
        Object liveJson = objectMapper.writeValueAsString(p);
        return new ResponseEntity<>(liveJson, HttpStatus.OK);
    }
    
    @DeleteMapping("/admin/livestreams/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLivestream(@PathVariable(value = "id") int id) {
        this.liveService.deleteLive(id);
    }
}
