package com.nuc.zp.thread.communication;

import java.util.concurrent.locks.LockSupport;

public class PrintABC4 {

    public static final Object obj = new Object();

    public static void main(String[] args) {
        C c = new C();
        B b = new B();
        A a = new A();
        Thread threadC = new Thread(c);
        Thread threadB = new Thread(b);
        Thread threadA = new Thread(a);
        c.nextThread = threadA;
        b.nextThread = threadC;
        a.nextThread = threadB;

        threadA.start();
        threadB.start();
        threadC.start();
        LockSupport.unpark(threadA);
    }

    static class A implements Runnable {
        Thread nextThread;
        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
                    LockSupport.park();
                    System.out.print("A");
                    LockSupport.unpark(nextThread);
                }
        }
    }

    static class B implements Runnable {
        Thread nextThread;

        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
                    LockSupport.park();
                    System.out.print("B");
                    LockSupport.unpark(nextThread);
            }
        }
    }

    static class C implements Runnable {
        Thread nextThread;

        @Override
        public void run() {
                for (int i = 0; i < 10; i++) {
                    LockSupport.park();
                    System.out.print("C");
                    System.out.println();
                    LockSupport.unpark(nextThread);
                }
        }
    }
}
