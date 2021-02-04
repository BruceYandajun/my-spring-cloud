package com.github.bruce.java8.parallel;

import java.util.concurrent.*;

import static com.github.bruce.utils.BaseUtil.line;

public class FutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(() -> {
            Thread.sleep(2000);
            System.out.println("execute");
            return 1.0;
        });

        Thread.sleep(6000);

        System.out.println("Future get");
        Double result = future.get(10000, TimeUnit.MILLISECONDS);

        line(result);
        executor.shutdown();
    }
}
