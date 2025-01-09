package com.usmp.event.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usmp.event.persistence.models.Users;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String index(Model modelo) {
        modelo.addAttribute("user", new Users());
        return "login/index";
    }

    @PostMapping
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

}
