package com.nuc.zp.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
    }
}
