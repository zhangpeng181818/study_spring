package com.nuc.zp.thread.communication;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC2 {

    static Lock lock = new ReentrantLock();
    static volatile AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintABC2.A());
        Thread threadB = new Thread(new PrintABC2.B());
        Thread threadC = new Thread(new PrintABC2.C());
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class A implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {

                lock.lock();
                try {
                    while (atomicInteger.get() == 0) {
                        System.out.print("A");
                        atomicInteger.set(1);
                        i++;
                    }

                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 10; ) {
                lock.lock();
                try {
                    while (atomicInteger.get()==1){
                        System.out.print("B");
                        atomicInteger.set(2);
                        i++;
                    }

                } finally {
                    lock.unlock();
                }
            }

        }

    }

    static class C implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; ) {
                lock.lock();
                try {
                    while (atomicInteger.get()==2){
                        System.out.print("C");
                        atomicInteger.set(0);
                        System.out.println();
                        i++;
                    }

                } finally {
                    lock.unlock();
                }
            }
        }

    }
}
