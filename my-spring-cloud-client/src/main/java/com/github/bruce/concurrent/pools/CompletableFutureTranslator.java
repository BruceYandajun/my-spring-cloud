package com.github.bruce.concurrent.pools;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureTranslator {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("Completed " + new CompletableFutureTranslator().translate2("abc"));
    }

    // todo
    public String translate1(String content) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService<>(executor);
        executorCompletionService.submit(() -> baidu(content));
        executorCompletionService.submit(() -> google(content));
        executorCompletionService.submit(() -> youdao(content));
        String result = executorCompletionService.take().get();
        executor.shutdown();
        return result;
    }

    public String translate2(String content) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newCachedThreadPool();
        CompletableFuture<String> baidu = CompletableFuture.supplyAsync(() -> baidu(content), executor);
        CompletableFuture<String> google = CompletableFuture.supplyAsync(() -> google(content), executor);
        CompletableFuture<String> youdao = CompletableFuture.supplyAsync(() -> youdao(content), executor);
        CompletableFuture<Object> result = CompletableFuture.anyOf(baidu, google, youdao);
        String result1 = (String) result.get();
        executor.shutdown();
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
