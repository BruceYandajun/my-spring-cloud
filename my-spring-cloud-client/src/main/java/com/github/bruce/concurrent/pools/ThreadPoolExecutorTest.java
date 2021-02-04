package com.github.bruce.concurrent.pools;

import java.util.concurrent.*;

public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 10, 60, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000),
                r -> new Thread(r, "MyCorePool-" + r.hashCode()),
                new ThreadPoolExecutor.AbortPolicy());
        executor.execute(new Worker("worker1"));
        executor.execute(new Worker("worker2"));
        executor.shutdown();
    }

    static class Worker extends Thread {

        public Worker(String name) {
            super(name);
        }

        @Override
        public void run() {
            System.out.println(this.getName() + " is running");
            System.out.println(Thread.currentThread().getName());
        }
    }
}
