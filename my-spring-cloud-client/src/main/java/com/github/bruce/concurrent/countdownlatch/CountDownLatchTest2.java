package com.github.bruce.concurrent.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest2 {

    /**
     * 让两个线程都跑完后主线程继续往下走
     */
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run!");
            countDownLatch.countDown();
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run!");
            countDownLatch.countDown();
        });
        t1.start();
        t2.start();
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + " run!");
    }

}

