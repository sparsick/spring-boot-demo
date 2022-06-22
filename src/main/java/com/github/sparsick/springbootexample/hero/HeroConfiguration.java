package com.github.sparsick.springbootexample.hero;


import com.github.sparsick.springbootexample.hero.universum.EmbbededHeroRepository;
import com.github.sparsick.springbootexample.hero.universum.HeroRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeroConfiguration {

    @Bean(name="heroRepository")
    HeroRepository heroRepositoryFactory() {
        return new EmbbededHeroRepository();
    }
}
