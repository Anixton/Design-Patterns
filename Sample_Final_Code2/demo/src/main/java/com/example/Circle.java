package com.example;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double cevreHesapla() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double alanHesapla() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle, radius=" + radius;
    }
}
