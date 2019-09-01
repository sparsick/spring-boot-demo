package com.github.sparsick.springbootexample.hero.universum;

import java.util.Collection;

public interface HeroRepository {
    void addHero(Hero hero);

    Collection<Hero> allHeros();
}
