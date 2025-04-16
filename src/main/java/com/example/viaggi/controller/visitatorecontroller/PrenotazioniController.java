package com.example.viaggi.controller.visitatorecontroller;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.viaggi.entity.Crawl;
import com.example.viaggi.entity.Prenotazioni;
import com.example.viaggi.repository.CrawlRepository;
import com.example.viaggi.repository.PostiRepository;
import com.example.viaggi.repository.PrenotazioniRepository;

@Controller
public class PrenotazioniController {


    @Autowired
    CrawlRepository crawlRepository;

    @Autowired
    PostiRepository postiRepository;

    @Autowired
    PrenotazioniRepository prenotazioniRepository;


    @GetMapping("/prenotazione/{crawlId}")
    public String showForm(@PathVariable Integer crawlId, Model model) {
Optional<Crawl> crawl = crawlRepository.findById(crawlId);
 if (crawl.isPresent()) {
            model.addAttribute("crawl", crawl.get());
            model.addAttribute("prenotazione", new Prenotazioni());  
            return "/visitatore/prenotazioneForm";  
        } else {
            return "redirect:/pubcrawl/all";  
        }
    }


    @PostMapping("/prenotazione")
    public String savePrenotazione(Prenotazioni prenotazione, Model model) {
      
        Optional<Crawl> crawlOptional = crawlRepository.findById(prenotazione.getCrawlId());
    
        
        
        
        
        if (crawlOptional.isPresent()) {
            Crawl crawl = crawlOptional.get();
            
            
             
            if (prenotazione.getDataEvento() != null && prenotazione.getDataEvento().isBefore(LocalDate.now())) {
                model.addAttribute("errorMessage", "La data selezionata non può essere nel passato.");
                model.addAttribute("crawl", crawl);
                model.addAttribute("prenotazione", prenotazione);
                return "/visitatore/prenotazioneForm"; 
            }
    
           
            LocalDate dataLimite = LocalDate.of(2025, 12, 31);
            if (prenotazione.getDataEvento() != null && prenotazione.getDataEvento().isAfter(dataLimite)) {
                model.addAttribute("errorMessage", "La data selezionata non può essere oltre il 31 dicembre 2025.");
                model.addAttribute("crawl", crawl);
                model.addAttribute("prenotazione", prenotazione);
                return "/visitatore/prenotazioneForm"; 
            }
           
           
           
           
           
            int prezzoTotale = crawl.getPrezzo() * prenotazione.getQuantita();
            prenotazione.setPrezzoTot(prezzoTotale);
            
    
            
            prenotazione.setCreatedAt(LocalDate.now());
    
            
            prenotazioniRepository.save(prenotazione);
    
            model.addAttribute("successMessage", "Prenotazione effettuata con successo!");
            model.addAttribute("prezzoTotale", prezzoTotale); 
            
            model.addAttribute("crawl", crawl); 
        model.addAttribute("prenotazione", prenotazione);
            
            
            return "/visitatore/prenotazioneConfermata";  
        } else {
            model.addAttribute("errorMessage", "Crawl non trovato.");
            return "errorPage";  
        }
    }
}



    



