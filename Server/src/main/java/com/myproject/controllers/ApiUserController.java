/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.myproject.controllers;

import com.myproject.components.JwtService;
import com.myproject.pojo.Comment;
import com.myproject.pojo.User;
import com.myproject.service.UserService;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Thanh
 */
@RestController
@RequestMapping("/api")
public class ApiUserController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private JavaMailSender emailSender;

    @PostMapping("/login/")
    @CrossOrigin
    public ResponseEntity<String> login(@RequestBody User user) {
        if (this.userService.authUser(user.getUsername(), user.getPassword()) == true) {
            String token = this.jwtService.generateTokenLogin(user.getUsername());

            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        return new ResponseEntity<>("error", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login-google/")
    @CrossOrigin
    public ResponseEntity<String> loginGoogle(@RequestParam Map<String, String> params) {
        User userRegister = this.userService.registerUserGoogle(params);
        String token = this.jwtService.generateTokenLogin(userRegister.getUsername());
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @DeleteMapping("/admin/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDepartment(@PathVariable(value = "id") int id) {
        this.userService.deleteUser(id);
    }

    @GetMapping("/username/{username}")
    @CrossOrigin
    public ResponseEntity<String> checkUsernameExist(@PathVariable(value = "username") String username) {
        User u = this.userService.getUserByUserName(username);
        if (u == null) {
            return new ResponseEntity<>("OK", HttpStatus.OK);

        } else {
            return new ResponseEntity<>("Username is exist", HttpStatus.OK);
        }
    }

    @GetMapping("/test/")
    @CrossOrigin
    public ResponseEntity<String> test(Principal pricipal) {
        return new ResponseEntity<>("SUCCESSFUL", HttpStatus.OK);
    }

    @PostMapping(path = "/register-user/",
            consumes = {MediaType.MULTIPART_FORM_DATA_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE})
    @CrossOrigin
    public ResponseEntity<Object> addUser(@RequestParam Map<String, String> params, @RequestPart MultipartFile avatar) {
        User user = this.userService.addUserAPI(params, avatar);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/current-user/", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public ResponseEntity<User> details(Principal user) {
        User u = this.userService.getUserByUserName(user.getName());

        return new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping("/change-password/")
    @CrossOrigin
    public ResponseEntity<Object> changePass(@RequestParam Map<String, String> params) {
        if (this.userService.authUser(params.get("username").toString(),
                params.get("password").toString())) {
            User u1 = this.userService.changePassword(params);
            return new ResponseEntity<>(u1, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @PostMapping("/isUser/")
    @CrossOrigin
    public ResponseEntity<Map<String, Object>> sendOTP(@RequestParam Map<String, String> params) {
        // Tạo và gửi mã OTP đến địa chỉ email
        String otp = String.valueOf(100000 + new Random().nextInt(900000));

        //Kiểm tra email có hay không
        User u = this.userService.getUserByUserName(params.get("username").toString());
        if (u != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("phone", u.getPhone());
            response.put("user", u);
            System.out.println(u.getPhone());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            System.out.println(u);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }
    }
    
    @PostMapping("/up-password/")
    @CrossOrigin
    public ResponseEntity<Object> upPass(@RequestParam Map<String, String> params) {
        if (this.userService.getUserByUserName(params.get("username").toString()) != null) {
            User u1 = this.userService.changePassword(params);
            return new ResponseEntity<>(u1, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

}
