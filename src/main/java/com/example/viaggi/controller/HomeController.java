package com.example.viaggi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
@GetMapping("/")
    public String indirizza(Model model){
       
        return "redirect:/homepage/benvenuto";
    }
}



