package com.usmp.event.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.usmp.event.viewModel.Contacto;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/contactus")
public class ContactController {
    @GetMapping
    public String index(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "/contactus/index";
    }
    @PostMapping
    public String saveForm(@ModelAttribute("contacto") Contacto contacto) {
        

        return "redirect:/contactus";
    }
    

}
