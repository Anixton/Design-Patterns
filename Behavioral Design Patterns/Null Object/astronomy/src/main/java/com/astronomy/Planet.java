package com.astronomy;

public class Planet implements CelestialBody {
    private String name;

    public Planet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
