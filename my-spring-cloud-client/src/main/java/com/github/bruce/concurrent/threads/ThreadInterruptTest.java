package com.github.bruce.concurrent.threads;

public class ThreadInterruptTest {
    public static void main(String[] args) {
        method();
    }
    private static void method() {
        Thread t = new Thread(() -> {
            try {
                while (true) {
                    System.out.println(System.currentTimeMillis());
                }
//                System.out.println(Thread.currentThread().getName() + " running!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        t.start();
        t.interrupt();
        System.out.println(t.isInterrupted());
    }
}
