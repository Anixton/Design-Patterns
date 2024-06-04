package com.example;

public class Rectangle implements Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public double cevreHesapla() {
        return 2 * (height + width);
    }

    @Override
    public double alanHesapla() {
        return height * width;
    }

    @Override
    public String toString() {
        return "Rectangle, height=" + height + " width=" + width;
    }
}
