package com.astronomy;

public class Star implements CelestialBody{
    private String name;

    public Star(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
