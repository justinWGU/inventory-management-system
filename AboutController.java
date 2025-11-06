package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    // controller that maps to '/about' and returns 'about' page
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
