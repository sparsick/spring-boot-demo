package com.github.sparsick.springbootexample.hero.universum;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class HeroController {

    private HeroRepositoryStrategy heroRepositoryStrategy;

    public HeroController(HeroRepositoryStrategy heroRepositoryStrategy) {
        this.heroRepositoryStrategy = heroRepositoryStrategy;
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
        for(HeroRepository heroRepository: heroRepositoryStrategy.findAllHeroRepositories()) {
            allHeros.addAll(heroRepository.allHeros());
        }
        return allHeros;
    }

    @GetMapping("/hero/new")
    public String newHero(Model model){
        model.addAttribute("newHero", new NewHeroModel());
        model.addAttribute("repos", heroRepositoryStrategy.findAllHeroRepositoryStrategyNames());
        return "hero/hero.new.html";
    }

    @PostMapping("/hero/new")
    public String addNewHero(@ModelAttribute("newHero") NewHeroModel newHeroModel) {
        HeroRepository heroRepository = heroRepositoryStrategy.findHeroRepository(newHeroModel.getRepository());
        heroRepository.addHero(newHeroModel.getHero());
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
