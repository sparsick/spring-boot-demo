package com.github.sparsick.springbootexample.hero.universum;

public enum ComicUniversum {
    MARVEL("Marvel"),
    DC_COMICS ("DC Comic");

    private String name;

    ComicUniversum(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
