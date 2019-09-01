package com.github.sparsick.springbootexample.hero.universum;

import java.util.Collection;

public interface HeroRepository {

    String getName();

    void addHero(Hero hero);

    Collection<Hero> allHeros();
}
