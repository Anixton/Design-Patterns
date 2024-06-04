package com.example;

public class Calisan extends FirmaBilesen {
    private String adSoyad;
    private int maas;

    public Calisan(String adSoyad, int maas) {
        this.adSoyad = adSoyad;
        this.maas = maas;
    }

    @Override
    public int maliyet() {
        return maas;
    }

    @Override
    public String toString() {
        return "Calisan [adSoyad=" + adSoyad + ", maas=" + maas + "]";
    }
}
