package com.example;

public class Main {
    public static void main(String[] args) {
        // Genel Müdürlük
        Mudurlukler genelMudur = new Mudurlukler("Genel Müdürlük");
        genelMudur.ekle(new Calisan("Ali", 5000));
        genelMudur.ekle(new Calisan("Veli", 6000));

        // Ege Bölge Müdürlüğü
        Mudurlukler egeBolge = new Mudurlukler("Ege Bölge Müdürlüğü");
        egeBolge.ekle(new Calisan("Ayse", 4000));
        egeBolge.ekle(new Calisan("Can", 3000));

        // İzmir İl Müdürlüğü
        Mudurlukler izmirIl = new Mudurlukler("İzmir İl Müdürlüğü");
        izmirIl.ekle(new Calisan("Selim", 2000));
        izmirIl.ekle(new Calisan("Murat", 1500));
        izmirIl.ekle(new Calisan("Zeynep", 2500));

        // Ege Bölge Müdürlüğü altına İzmir İl Müdürlüğü'nü ekle
        egeBolge.ekle(izmirIl);

        // Akdeniz Bölge Müdürlüğü
        Mudurlukler akdenizBolge = new Mudurlukler("Akdeniz Bölge Müdürlüğü");
        akdenizBolge.ekle(new Calisan("Emre", 3000));
        akdenizBolge.ekle(new Calisan("Ahmet", 4000));

        // Antalya İl Müdürlüğü
        Mudurlukler antalyaIl = new Mudurlukler("Antalya İl Müdürlüğü");
        antalyaIl.ekle(new Calisan("Bahar", 2500));
        antalyaIl.ekle(new Calisan("Sedat", 1500));
        antalyaIl.ekle(new Calisan("Vedat", 2500));

        // Akdeniz Bölge Müdürlüğü altına Antalya İl Müdürlüğü'nü ekle
        akdenizBolge.ekle(antalyaIl);

        // Genel Müdürlük altına Ege ve Akdeniz Bölge Müdürlüklerini ekle
        genelMudur.ekle(egeBolge);
        genelMudur.ekle(akdenizBolge);

        // Maliyetleri hesaplayıp yazdırma
        System.out.println("Ege Bölge Müdürlüğü Maliyeti: " + egeBolge.maliyet());
        System.out.println("Akdeniz Bölge Müdürlüğü Maliyeti: " + akdenizBolge.maliyet());
        System.out.println("Genel Müdürlük Maliyeti: " + genelMudur.maliyet());
    }
}