package com.example;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new FirstTask());
        Thread thread2 = new Thread(new SecondTask());

        thread1.start();
        thread2.start();
    }
}