package com.github.sparsick.springbootexample;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class HeroRepository {

    private Set<Hero> heroes = new HashSet<>();

    @PostConstruct
    public void init(){
        heroes.add(new Hero("Batman", "Gotham City"));
        heroes.add(new Hero("Superman", "Metropolis"));
    }

    public void addCustomer(Hero hero) {
        heroes.add(hero);
    }

    public Collection<Hero> allCustomers(){
        return new HashSet<>(heroes);
    }

}
