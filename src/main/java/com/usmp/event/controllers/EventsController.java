package com.usmp.event.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/events")
public class EventsController {
    @GetMapping
    public String index() {
        return "events/index";
    }

}
