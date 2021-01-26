package com.github.bruce.concurrent.pools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureTranslator {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Completed " + new CompletableFutureTranslator().translate1("abc"));
    }

    // todo
    public String translate1(String content) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executor);
        List<Future<String>> futures = new ArrayList<>();
        Future<String> future1 = executorCompletionService.submit(() -> baidu(content));
        futures.add(future1);
        Future<String> future2 = executorCompletionService.submit(() -> google(content));
        futures.add(future2);
        Future<String> future3 = executorCompletionService.submit(() -> youdao(content));
        futures.add(future3);
        String result = executorCompletionService.take().get();
        futures.forEach(f -> f.cancel(true));
        return result;
    }

    public String translate2(String content) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> baidu = CompletableFuture.supplyAsync(() -> baidu(content), executor);
        CompletableFuture<String> google = CompletableFuture.supplyAsync(() -> google(content), executor);
        CompletableFuture<String> youdao = CompletableFuture.supplyAsync(() -> youdao(content), executor);
        CompletableFuture<Object> result = CompletableFuture.anyOf(baidu, google, youdao);
        String result1 = (String) result.get();
        executor.shutdownNow();
        return result1;
    }

    public String baidu(String content) {
        randomSleep("baidu");
        return "baidu";
    }

    public String google(String content) {
        randomSleep("google");
        return "googe";
    }

    public String youdao(String content) {
        randomSleep("youdao");
        return "youdao";
    }

    private void randomSleep(String s) {
        try {
            int i = new Random().nextInt(3000);
            Thread.sleep(i);
            System.out.println(s + " sleep " + i + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
