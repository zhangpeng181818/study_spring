package com.nuc.zp.thread.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();
        new Thread(() -> {
            lock.lock();
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assert !lock.isLocked();
        assert !lock.hasQueuedThreads();
        lock.lock();
        try {
            assert lock.hasWaiters(condition);
            assert lock.getWaitQueueLength(condition) == 1;
        } finally {
            lock.unlock();
        }
    }
}
