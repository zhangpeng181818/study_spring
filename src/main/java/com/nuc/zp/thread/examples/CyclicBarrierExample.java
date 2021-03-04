package com.nuc.zp.thread.examples;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {

    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(10 + 1);

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        int parties = cyclicBarrier.getParties();
        for (int i = 0; i < parties - 1; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName());
                } finally {
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }, "running-" + i).start();
        }
        cyclicBarrier.await();
        System.out.println("哈哈");
        for (int i = 0; i < parties-1; i++) {
            new Thread(()->{
                    try {
                        System.out.println(Thread.currentThread().getName());
                        cyclicBarrier.await();
                    } catch (InterruptedException | BrokenBarrierException e) {
                        e.printStackTrace();
                    }
            },"running2-"+i).start();
        }
        cyclicBarrier.await();
        System.out.println("哈哈哈");
    }
}
