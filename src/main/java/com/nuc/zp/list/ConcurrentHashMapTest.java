package com.nuc.zp.list;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap currentHashMap = new ConcurrentHashMap<>(32);

        for (int i = 0; i < 47; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentHashMap.put("abc" + i, i);

        }

        new Thread(() -> {
            currentHashMap.put("通话", 11);
            System.out.println("---");

        },"1").start();

        new Thread(() -> {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentHashMap.put("重地", 22);
            System.out.println("---");

        },"2").start();



        new Thread(() -> {
            currentHashMap.put("abc5", "xx");
            System.out.println("---");

        },"3").start();


    }
}
