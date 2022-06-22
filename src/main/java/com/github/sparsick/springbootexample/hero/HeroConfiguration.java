package com.github.sparsick.springbootexample.hero;


import com.github.sparsick.springbootexample.hero.universum.EmbbededHeroRepository;
import com.github.sparsick.springbootexample.hero.universum.HeroRepository;
import com.github.sparsick.springbootexample.hero.universum.MongoDbHeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeroConfiguration.class);

    @Bean(name="heroRepository")
    HeroRepository heroRepositoryFactory(@Value("${mongodb.enabled}") boolean mongodbEnabled, EmbbededHeroRepository embbededHeroRepository, MongoDbHeroRepository mongoDbHeroRepository) {
        if (mongodbEnabled) {
            LOGGER.info("Mongodb is chosen.");
            return mongoDbHeroRepository;
        }
        LOGGER.info("Embedded is chosen.");
        return embbededHeroRepository;
    }
}
