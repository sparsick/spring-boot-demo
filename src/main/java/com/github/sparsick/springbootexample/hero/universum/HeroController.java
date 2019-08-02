package com.github.sparsick.springbootexample.hero.universum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Controller
public class HeroController {

    @Autowired
    private HeroRepository heroRepository;

    @GetMapping("/hero")
    public String viewAllHeros(Model model) {
        model.addAttribute("heros", heroRepository.allHeros());
        model.addAttribute("ipAddress", inspectLocalHost());

        return "hero/hero.list.html";
    }

    @GetMapping("/hero/new")
    public String newHero(Model model){
        model.addAttribute("hero", new Hero());
        return "hero/hero.new.html";
    }

    @PostMapping("/hero/new")
    public String addNewHero(@ModelAttribute("hero") Hero hero){
        heroRepository.addHero(hero);
        return "redirect:/hero";
    }

    private String inspectLocalHost() {
        try {
            return Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

}
