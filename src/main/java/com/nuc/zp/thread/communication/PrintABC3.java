package com.nuc.zp.thread.communication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC3 {

    static Lock lock = new ReentrantLock();
    static Condition conditionA = lock.newCondition();
    static Condition conditionB = lock.newCondition();
    static Condition conditionC = lock.newCondition();

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintABC3.A());
        Thread threadB = new Thread(new PrintABC3.B());
        Thread threadC = new Thread(new PrintABC3.C());
        threadA.start();
        threadB.start();
        threadC.start();
    }

    static class A implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; ) {
                    conditionB.signal();
                    System.out.print("A");
                    i++;
                    conditionA.await();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                conditionB.signal();
                lock.unlock();
            }
        }
    }

    static class B implements Runnable {
        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; ) {
                    conditionC.signal();
                    System.out.print("B");
                    i++;
                    conditionB.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                conditionC.signal();
                lock.unlock();
            }
        }
    }


    static class C implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                for (int i = 0; i < 10; ) {
                    conditionA.signal();
                    System.out.print("C");
                    System.out.println();
                    i++;
                    conditionC.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}
