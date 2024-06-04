package com.example;

public class DikUcgen implements Shape {
    private double a;
    private double b;
    private double e;

    public DikUcgen(double a, double b) {
        this.a = a;
        this.b = b;
        this.e = Math.sqrt(a * a + b * b);
    }

    @Override
    public double cevreHesapla() {
        return a + b + e;
    }

    @Override
    public double alanHesapla() {
        return (a * b) / 2;
    }

    @Override
    public String toString() {
        return "DikUcgen, a=" + a + " b=" + b + " e=" + e;
    }

    public void tangentValues() {
        System.out.println("Tanjant değerleri: a/b=" + (a / b) + ", b/a=" + (b / a));
    }
}
