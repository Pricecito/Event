package com.usmp.event.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usmp.event.persistence.models.Users;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String index(Model modelo){
        modelo.addAttribute("user", new Users());
        return "login/index";
    }
    
}
