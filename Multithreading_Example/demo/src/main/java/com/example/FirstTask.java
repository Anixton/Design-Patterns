package com.example;

public class FirstTask implements Runnable {
    @Override
    public void run() {
        for (int i = 1; i <= 15; i++) {
            System.out.println("First Task - Count: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

}
