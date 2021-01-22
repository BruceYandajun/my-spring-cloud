package com.github.bruce.concurrent.pools;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ScheduledThreadPoolTest {
    private static ScheduledExecutorService executors = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {
        Worker bruce = new Worker("Bruce");
        executors.schedule(bruce);
    }

    static class Worker implements Runnable {

        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(this.name + " is running!");
        }
    }
}
