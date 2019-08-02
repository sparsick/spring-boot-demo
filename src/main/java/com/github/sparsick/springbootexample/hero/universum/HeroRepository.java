package com.github.sparsick.springbootexample.hero.universum;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class HeroRepository {

    private Set<Hero> heroes = new HashSet<>();

    @PostConstruct
    public void init(){
        heroes.add(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
        heroes.add(new Hero("Superman", "Metropolis", ComicUniversum.DC_COMICS));
    }

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public Collection<Hero> allHeros(){
        return new HashSet<>(heroes);
    }

}
