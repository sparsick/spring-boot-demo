package com.github.sparsick.springbootexample.hero.universum;

import java.util.Objects;

public class Hero {

    private String name;

    private String city;

    public Hero(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Hero() {

    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name) &&
                Objects.equals(city, hero.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, city);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
