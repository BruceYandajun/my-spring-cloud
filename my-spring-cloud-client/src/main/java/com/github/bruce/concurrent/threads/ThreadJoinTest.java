package com.github.bruce.concurrent.threads;

import com.google.common.collect.Lists;

import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadJoinTest {
    /**
     * 用join方法等待两个线程都执行完
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList list = Lists.newCopyOnWriteArrayList();
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run!");
        });
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " run!");
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(Thread.currentThread().getName() + " run!");
    }
}
