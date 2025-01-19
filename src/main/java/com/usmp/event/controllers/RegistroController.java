package com.usmp.event.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.usmp.event.persistence.models.Users;
import com.usmp.event.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/registro")
public class RegistroController {
    @Autowired
    private UserService user_Service;

    @GetMapping
    public String index(Model modelo, HttpSession session) {
        if (Objects.isNull(modelo.getAttribute("viewModel"))) {
            modelo.addAttribute("user", new Users());
        } else {
            modelo.addAttribute("user", modelo.getAttribute("viewModel"));
        }
        return "registro/index";

    }

    /*
     * @PostMapping
     * public String save(Users user, RedirectAttributes redirect) {
     * redirect.addAttribute("viewUser", user);
     * return "redirect:/registro/confirmation";
     * }
     */

    @GetMapping("/confirmation")
    public String messageConfirm(/* @RequestParam("viewUser") */ Users modelView, Model modelo) {
        modelo.addAttribute("viewModel", modelView);
        return "confirmation/index";
    }

    @GetMapping("/afirmative")
    public String messageCongrulations(@ModelAttribute("viewModel") Users user) {
        user_Service.saveOrUpdateUser(user);
        return "confirmation/message";
    }

}
