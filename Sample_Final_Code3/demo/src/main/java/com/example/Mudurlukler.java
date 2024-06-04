package com.example;

import java.util.ArrayList;

public class Mudurlukler extends FirmaBilesen {
    private String mudurlukAdi;
    private ArrayList<FirmaBilesen> bilesenler = new ArrayList<>();

    public Mudurlukler(String mudurlukAdi) {
        this.mudurlukAdi = mudurlukAdi;
    }

    public void ekle(FirmaBilesen bilesen) {
        bilesenler.add(bilesen);
    }

    @Override
    public int maliyet() {
        int toplamMaliyet = 0;
        for (FirmaBilesen bilesen : bilesenler) {
            toplamMaliyet += bilesen.maliyet();
        }
        return toplamMaliyet;
    }

    @Override
    public String toString() {
        return "Mudurlukler [mudurlukAdi=" + mudurlukAdi + ", bilesenler=" + bilesenler + "]";
    }
}
