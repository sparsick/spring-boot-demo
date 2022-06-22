package com.github.sparsick.springbootexample.hero.universum;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.stream.Collectors;

@Repository
public class MongoDbHeroRepository implements HeroRepository {


    private HeroMongoRepository mongoRepository;

    public MongoDbHeroRepository(HeroMongoRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
    }

    @Override
    public void addHero(Hero hero) {
        mongoRepository.save(hero);
    }

    @Override
    public Collection<Hero> allHeros() {
        return mongoRepository.findAll();
    }

    @Override
    public Collection<Hero> findHerosBySearchCriteria(String searchCriteria) {
        return mongoRepository.findAll().stream().filter(hero -> StringUtils.containsIgnoreCase(hero.toString(), searchCriteria)).collect(Collectors.toSet());
    }
}
