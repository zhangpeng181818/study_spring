package com.nuc.zp.thread.examples;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    private static CountDownLatch countDownLatch = new CountDownLatch(10);

    public static void main(String[] args) throws InterruptedException {
        long latchCount = countDownLatch.getCount();
        for (int i = 0; i < latchCount; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                } finally {
                    countDownLatch.countDown();
                }
            }, "running-" + i).start();
        }
        countDownLatch.await();
        System.out.println("哈哈");
    }

}
