package com.nuc.zp.thread.communication;

import java.util.concurrent.atomic.AtomicInteger;

public class PrintABC {

    static final Object obj = new Object();

    static volatile AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(new A());
        Thread threadB = new Thread(new B());
        Thread threadC = new Thread(new C());
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class A implements Runnable {

        @Override
        public void run() {
                for (int i = 0; i < 10;) {
                    synchronized (obj) {
                        while (atomicInteger.get() == 0) {
                        System.out.print("A");
                        atomicInteger.set(1);
                            i++;
                    }
                    try {
                        obj.notifyAll();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            synchronized (obj) {

            for (int i = 0; i < 10;) {
                    while (atomicInteger.get() == 1) {
                        System.out.print("B");
                        atomicInteger.set(2);
                        i++;

                    }

                    try {
                        obj.notifyAll();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            obj.notifyAll();
            }

        }

    }

    static class C implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                synchronized (obj) {
                    while (atomicInteger.get() == 2) {
                        System.out.print("C");
                        System.out.println();
                        atomicInteger.set(0);
                        i++;
                    }
                    try {
                        obj.notifyAll();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
