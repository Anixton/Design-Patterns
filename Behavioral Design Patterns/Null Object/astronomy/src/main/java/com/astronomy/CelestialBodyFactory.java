package com.astronomy;

public class CelestialBodyFactory {
    public CelestialBody getCelestialBody(String type, String name) {
        if (type.equals("Star")) {
            return new Star(name);
        } else if (type.equals("Planet")) {
            return new Planet(name);
        }
        return new NullCelestialBody();
    }
}
