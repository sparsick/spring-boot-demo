package com.github.sparsick.springbootexample.hero.universum;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HeroMongoRepository extends MongoRepository<Hero, String> {

}
