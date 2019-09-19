package com.github.sparsick.springbootexample.hero.universum;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Component
public class HeroRepositoryStrategy {

    private Map<String, HeroRepository> heroRepositoryStrategies;

    public HeroRepositoryStrategy(Set<HeroRepository> heroRepositories) {
        heroRepositoryStrategies = createStrategies(heroRepositories);
    }

    HeroRepository findHeroRepository(String repositoryName) {
        return heroRepositoryStrategies.get(repositoryName);
    }

    Set<String> findAllHeroRepositoryStrategyNames () {
        return heroRepositoryStrategies.keySet();
    }

    Collection<HeroRepository> findAllHeroRepositories(){
        return heroRepositoryStrategies.values();
    }


    private Map<String, HeroRepository> createStrategies(Set<HeroRepository> heroRepositories){
        Map<String, HeroRepository> heroRepositoryStrategies = new HashMap<>();
        heroRepositories.forEach(heroRepository -> heroRepositoryStrategies.put(heroRepository.getName(), heroRepository));
        return heroRepositoryStrategies;
    }

}
