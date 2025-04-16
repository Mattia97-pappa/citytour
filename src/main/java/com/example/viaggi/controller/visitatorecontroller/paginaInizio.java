package com.example.viaggi.controller.visitatorecontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/homepage")
public class paginaInizio {


    @GetMapping("/benvenuto")
    public String benvenutoHome(){
        return "visitatore/homepage";
    }

}
