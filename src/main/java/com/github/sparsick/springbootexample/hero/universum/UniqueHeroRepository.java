package com.github.sparsick.springbootexample.hero.universum;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class UniqueHeroRepository implements HeroRepository {

    private Set<Hero> heroes = new HashSet<>();

    @PostConstruct
    public void init() {
        heroes.add(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
        heroes.add(new Hero("Superman", "Metropolis", ComicUniversum.DC_COMICS));
    }

    @Override
    public String getName() {
        return "Unique";
    }

    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    @Override
    public Collection<Hero> allHeros() {
        return new HashSet<>(heroes);
    }

}
