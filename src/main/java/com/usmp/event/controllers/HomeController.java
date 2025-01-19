package com.usmp.event.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String index() {
        return "home/index";

    }


}
