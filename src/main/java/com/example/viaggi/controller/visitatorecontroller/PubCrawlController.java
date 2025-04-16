package com.example.viaggi.controller.visitatorecontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.viaggi.entity.Crawl;
import com.example.viaggi.entity.Posti;
import com.example.viaggi.repository.CrawlRepository;

@Controller
@RequestMapping("/pubcrawl")
public class PubCrawlController {

@Autowired
private CrawlRepository crawlRepository;


@GetMapping("/all")
public String mostraCrawl(Model model){
List<Crawl> crawl= crawlRepository.findAll();
model.addAttribute("crawl",crawl); 
return "/visitatore/crawl";

}  



 @GetMapping("/selezionaProdotto/{id}")
    public String viewProdottoDettagli(@PathVariable Integer id, Model model) {
        Optional<Crawl> crawl = crawlRepository.findById(id);
        if (crawl.isPresent()) {
            model.addAttribute("crawl", crawl.get());
            return "/visitatore/selezionaProdotto"; 
        } else {
            return "redirect:/visitatore/crawl"; 
        }
    }
}



