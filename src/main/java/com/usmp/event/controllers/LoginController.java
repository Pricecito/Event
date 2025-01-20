package com.usmp.event.controllers;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usmp.event.persistence.models.Users;
import com.usmp.event.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService service;

    @GetMapping
    public String index(Model modelo, HttpSession session) {
        session.removeAttribute("login");
        modelo.addAttribute("user", new Users());
        return "login/index";
    }

    @PostMapping
    public String searchUser(Users user, HttpSession session) {
        if (service.findEmailAndPassword(user)) {
            session.setAttribute("login", user);
            return "redirect:/home";
        } else {
            return "redirect:/error";
        }

    }

}
