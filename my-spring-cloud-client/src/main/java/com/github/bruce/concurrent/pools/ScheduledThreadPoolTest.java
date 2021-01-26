package com.github.bruce.concurrent.pools;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolTest {
    private static ScheduledExecutorService executors = Executors.newScheduledThreadPool(2);

    public static void main(String[] args) {
        Worker bruce = new Worker("Bruce");
        Worker david = new Worker("david");
        Worker jack = new Worker("jack");
        executors.schedule(bruce, 1000L, TimeUnit.MILLISECONDS);
        executors.schedule(david, 5000L, TimeUnit.MILLISECONDS);
        executors.schedule(jack, 10000L, TimeUnit.MILLISECONDS);
        executors.shutdown();
    }

    static class Worker implements Callable<String> {

        private String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public String call() {
            System.out.println(name + " is calling, now is " + new Date());
            return this.name;
        }
    }
}
