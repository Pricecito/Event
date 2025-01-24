package com.usmp.event.controllers;

import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usmp.event.persistence.models.Users;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(HttpSession session, Model modelo) {
        if (Objects.nonNull(session.getAttribute("login"))) {
            modelo.addAttribute("userSession", (Users) session.getAttribute("login"));
        }
        return "/home/index";

    }

}
