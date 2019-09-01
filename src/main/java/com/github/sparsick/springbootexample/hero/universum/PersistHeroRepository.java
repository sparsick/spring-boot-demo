package com.github.sparsick.springbootexample.hero.universum;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;

@Repository
public class PersistHeroRepository implements HeroRepository {
    @Override
    public void addHero(Hero hero) {

    }

    @Override
    public Collection<Hero> allHeros() {
        return Collections.emptyList();
    }

    @Override
    public String getName() {
        return "Persist";
    }
}
