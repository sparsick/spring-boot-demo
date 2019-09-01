package com.github.sparsick.springbootexample.hero.universum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class HeroController {

    @Autowired
    private Set<HeroRepository> heroRepositories;

    private Map<Class, HeroRepository> heroRepositoryFactory = new HashMap<>();

    @PostConstruct
    void init(){
        heroRepositories.forEach(heroRepository -> heroRepositoryFactory.put(heroRepository.getClass(), heroRepository));
    }

    @GetMapping("/hero")
    public String viewAllHeros(Model model) {
        List<Hero> allHeros = collectAllHeros();
        model.addAttribute("heros", allHeros);
        model.addAttribute("ipAddress", inspectLocalHost());

        return "hero/hero.list.html";
    }

    private List<Hero> collectAllHeros() {
        List<Hero> allHeros = new ArrayList<>();
        for(HeroRepository heroRepository: heroRepositories) {
            allHeros.addAll(heroRepository.allHeros());
        }
        return allHeros;
    }

    @GetMapping("/hero/new")
    public String newHero(Model model){
        model.addAttribute("hero", new Hero());
        return "hero/hero.new.html";
    }

    @PostMapping("/hero/new")
    public String addNewHero(@ModelAttribute("hero") Hero hero){
        heroRepositoryFactory.get(InMemoryHeroRepository.class).addHero(hero);
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
