package com.github.bruce.concurrent.queues;

import com.google.common.primitives.Ints;
import lombok.Data;

import java.util.*;
import java.util.concurrent.*;

public class SignalTest {
    private static List<DelayQueue<Signal>> signalList = new ArrayList<>();
    private static int processors = Runtime.getRuntime().availableProcessors();
    private static ExecutorService producer = Executors.newSingleThreadExecutor();
    private static ExecutorService consumer = Executors.newFixedThreadPool(processors);

    public static void main(String[] args) {
        produce();
        consume();
    }

    private static void produce() {
        producer.execute(() -> {
            DelayQueue<Signal> queue = null;
            for (int i = 0; i < 5; i ++) {
                if (i % processors == 0) {
                    queue = new DelayQueue<>();
                    signalList.add(queue);
                }
                for (int j = 0; j < 6; j ++) {
                    queue.offer(new Signal("signal_" + j, 100));
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Produced " + signalList);
        });
    }

    private static void consume() {
        for (DelayQueue<Signal> queue : signalList) {
            consumer.execute(() -> {
                while (true) {
                    try {
                        Signal signal = queue.take();
                        System.out.println("Consumed" + signal);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}

@Data
class Signal implements Delayed {

    private String name;
    private long startTime;

    public Signal(String name, long delay) {
        this.name = name;
        this.startTime = System.currentTimeMillis() + delay;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long diff = startTime - System.currentTimeMillis();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Ints.saturatedCast(this.getDelay(TimeUnit.MILLISECONDS) - o.getDelay(TimeUnit.MILLISECONDS));
    }

    @Override
    public String toString() {
        return name + ":" + startTime;
    }
}
