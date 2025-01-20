package com.usmp.event.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.usmp.event.persistence.models.Users;
import com.usmp.event.service.UserService;

import io.micrometer.core.ipc.http.HttpSender;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private UserService user_Service;

    @GetMapping
    public String index(Model modelo) {
        modelo.addAttribute("user", new Users());
        return "registro/index";

    }

    @PostMapping
    public String save(Users user, RedirectAttributes redirect, HttpSession session) {
        user_Service.saveOrUpdateUser(user);
        session.setAttribute("login", user);
        redirect.addFlashAttribute("user", user);
        return "redirect:/registro/afirmative";
    }

    @GetMapping("/afirmative")
    public String messageCongrulations(@ModelAttribute("user") Users user, Model modelo) {
        modelo.addAttribute("user", user);
        return "confirmation/index";
    }

}
