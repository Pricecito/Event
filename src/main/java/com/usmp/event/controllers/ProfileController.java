package com.usmp.event.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    
    public String index(){
        
        return "profile/index";
    }
}
