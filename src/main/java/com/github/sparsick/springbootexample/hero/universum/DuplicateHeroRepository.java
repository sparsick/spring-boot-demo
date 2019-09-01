package com.github.sparsick.springbootexample.hero.universum;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class DuplicateHeroRepository implements HeroRepository {

    private List<Hero> heroes = new ArrayList<>();
    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    @Override
    public Collection<Hero> allHeros() {
        return heroes;
    }

    @Override
    public String getName() {
        return "Duplicate";
    }
}
