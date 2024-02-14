package com.astronomy;

public class NullCelestialBody implements CelestialBody{
    @Override
    public String getName() {
        return "No celestial body found";
    }
}
