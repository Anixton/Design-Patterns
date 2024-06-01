package com.example;

public class SecondTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("Second Task - Count: " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
