package com.github.sparsick.springbootexample.hero.universum;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//@Repository
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
    public Collection<Hero> findHerosBySearchCriteria(String searchCriteria) {
        return heroes.stream().filter( hero -> StringUtils.containsIgnoreCase(hero.toString(), searchCriteria)).collect(Collectors.toList());

    }

    @Override
    public String getName() {
        return "Duplicate";
    }
}
