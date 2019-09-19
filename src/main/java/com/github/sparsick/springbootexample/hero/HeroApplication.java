package com.github.sparsick.springbootexample.hero;

import com.github.sparsick.springbootexample.hero.universum.HeroRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@SpringBootApplication
public class HeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroApplication.class, args);
	}



}
