package com.example.viaggi.controller.visitatorecontroller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.viaggi.entity.Posti;
import com.example.viaggi.repository.PostiRepository;

@Controller
@RequestMapping("/viaggi")
public class VisitatoreController {

    @Autowired
    private PostiRepository postiRepository;

@GetMapping("/luoghi-per-viaggi")
public String luoghiPerViaggi(Model model){
List<Posti> posti=postiRepository.findAll();   
model.addAttribute("posti",posti);
return "visitatore/luoghiPerViaggi";
}



@GetMapping("/contatti")
public String contatti(){
    return "visitatore/contatti";
}

}
