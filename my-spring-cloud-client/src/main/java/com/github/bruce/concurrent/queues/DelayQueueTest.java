package com.github.bruce.concurrent.queues;

import java.util.concurrent.DelayQueue;

public class DelayQueueTest {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Signal> dq = new DelayQueue<>();
        for (int i = 0; i < 500; i ++) {
            dq.offer(new Signal("Signal" + i, i * 10000));
        }
        while (true) {
            Signal take = dq.take();
            System.out.println(take);
        }
    }

}
