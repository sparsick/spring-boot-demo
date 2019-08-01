package com.github.sparsick.springbootexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping("/hero")
    public String viewAllCustomer(Model model) {
        model.addAttribute("customers", heroRepository.allCustomers());

        return "hero/hero.list.html";
    }

    @GetMapping("/hero/new")
    public String newCustomer(Model model){
        model.addAttribute("hero", new Hero());
        return "hero/hero.new.html";
    }

    @PostMapping("/hero/new")
    public String addNewCustomer(@ModelAttribute("hero") Hero hero){
        heroRepository.addCustomer(hero);
        return "redirect:/hero";
    }

}
