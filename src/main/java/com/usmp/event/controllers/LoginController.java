package com.usmp.event.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usmp.event.persistence.models.Users;
import com.usmp.event.service.UserService;

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
        return service.findEmailAndPassword(user)? "redirect:/home":"redirect:/error";
    }

}
