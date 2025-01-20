package com.usmp.event.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usmp.event.viewModel.Contacto;

@Controller
@RequestMapping("/contactus")
public class ContactController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "/contactus/index";
    }

}
