package com.nuc.zp.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(10);
        int result = atomicInteger.accumulateAndGet(5, Integer::sum);
        assert result == 15;
        assert atomicInteger.get() == 15;

    }
}
