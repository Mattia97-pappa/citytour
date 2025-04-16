package com.example.viaggi.controller;


import jakarta.servlet.http.HttpSession;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.viaggi.entity.Admin;
import com.example.viaggi.entity.Prenotazioni;
import com.example.viaggi.repository.AdminRepository;
import com.example.viaggi.repository.PrenotazioniRepository;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private PrenotazioniRepository prenotazioniRepository;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        Model model) {

        Optional<Admin> adminOpt = adminRepository.findByUsernameAndPassword(username, password);

        if (adminOpt.isPresent()) {
            Admin admin = adminOpt.get();
            session.setAttribute("admin", admin);
            return "redirect:/admin/dashboard";
        } else {
            model.addAttribute("error", "Credenziali non valide.");
            return "login";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam(name = "mese", required = false) String mese, 
                            HttpSession session, Model model) {
        Admin admin = (Admin) session.getAttribute("admin");
    
        if (admin != null) {
            Integer crawlId = admin.getCrawlId();
            
            
            List<Prenotazioni> prenotazioni;
            if (mese != null && !mese.isEmpty()) {
                
                prenotazioni = prenotazioniRepository.findByCrawlIdAndCreatedAtMonth(crawlId, mese);
            } else {
               
                prenotazioni = prenotazioniRepository.findByCrawlId(crawlId);
            }
    
            model.addAttribute("prenotazioni", prenotazioni);
            return "adminDashboard";
        } else {
            return "redirect:/admin/login";
        }
    }
    

    @GetMapping("/prenotazione/elimina/{id}")
    public String eliminaPrenotazione(@PathVariable Integer id, HttpSession session) {
        Admin admin = (Admin) session.getAttribute("admin");
    
        if (admin != null) {
            prenotazioniRepository.deleteById(id);
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/admin/login";
        }
    }
    
   
   
    @GetMapping("/prenotazione/modifica/{id}")
    public String mostraFormModifica(@PathVariable Integer id, Model model) {
        Optional<Prenotazioni> prenotazioneOpt = prenotazioniRepository.findById(id);
        if (prenotazioneOpt.isPresent()) {
            model.addAttribute("prenotazione", prenotazioneOpt.get());
            return "modificaPrenotazione";
        } else {
            return "redirect:/admin/dashboard";
        }
    }
    
   
    @PostMapping("/prenotazione/modifica")
public String salvaModifiche(@ModelAttribute Prenotazioni prenotazione) {
    prenotazioniRepository.save(prenotazione);
    return "redirect:/admin/dashboard";
}

   
   
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/admin/login";
    }
}
