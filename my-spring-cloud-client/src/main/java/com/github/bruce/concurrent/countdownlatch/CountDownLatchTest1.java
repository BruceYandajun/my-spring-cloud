package com.github.bruce.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest1 {

    /**
     * 让2个线程憋住，同时跑
     */
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Thread t1 = new Thread(() -> {
            try {
                countDownLatch.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run!");
        });
        Thread t2 = new Thread(() -> {
            try {
                countDownLatch.await();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run!");
        });
        t1.start();
        t2.start();

        try {
            System.out.println(Thread.currentThread().getName() + " run!");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }

}

