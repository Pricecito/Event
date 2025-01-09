package com.usmp.event.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usmp.event.persistence.models.Users;
import com.usmp.event.service.UserService.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService service;

    @GetMapping
    public String index(Model modelo) {
        modelo.addAttribute("user", new Users());
        return "login/index";
    }

    @PostMapping
    public String searchUser(Users user) {
        if (service.findEmail(user.getEmail()) && service.findPassword(user.getPassword())) {
            return "redirect: /home";
        }
        return "redirect: /error";
    }

}
