package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];

        try (BufferedReader br = new BufferedReader(new FileReader("demo\\girdi.txt"))) {
            for (int i = 0; i < 5; i++) {
                String line = br.readLine();
                String[] parts = line.split(" ");

                switch (parts[0]) {
                    case "Circle":
                        double radius = Double.parseDouble(parts[1]);
                        shapes[i] = new Circle(radius);
                        break;
                    case "Rectangle":
                        double height = Double.parseDouble(parts[1]);
                        double width = Double.parseDouble(parts[2]);
                        shapes[i] = new Rectangle(height, width);
                        break;
                    case "DikUcgen":
                        double a = Double.parseDouble(parts[1]);
                        double b = Double.parseDouble(parts[2]);
                        shapes[i] = new DikUcgen(a, b);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Shape shape : shapes) {
            System.out.println(shape.toString());
            System.out.println("Çevre: " + shape.cevreHesapla());
            System.out.println("Alan: " + shape.alanHesapla());

            if (shape instanceof DikUcgen) {
                ((DikUcgen) shape).tangentValues();
            }
        }
    }
}
