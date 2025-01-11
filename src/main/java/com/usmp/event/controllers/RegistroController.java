package com.usmp.event.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.usmp.event.persistence.models.Users;
import com.usmp.event.service.UserService.UserService;

@Controller
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private UserService service;

    @GetMapping
    public String index(Model modelo) {
        modelo.addAttribute("user", new Users());
        return "/register/index";
    }

    @PostMapping
    public String registrar(Users user) {
        service.saveOrUpdateUser(user);
        return "/register/confirmacion";
    }

}
