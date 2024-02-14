package com.astronomy;


public class App 
{
    public static void main( String[] args )
    {
        CelestialBodyFactory factory = new CelestialBodyFactory();

        CelestialBody body1 = factory.getCelestialBody("Star","Sun");
        System.out.println(body1.getName());

        CelestialBody body2 = factory.getCelestialBody("Unknown","Unknown");
        System.out.println(body2.getName());

        CelestialBody body3 = factory.getCelestialBody("Planet","Earth");
        System.out.println(body3.getName());
    }
}
