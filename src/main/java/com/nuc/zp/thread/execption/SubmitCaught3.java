package com.nuc.zp.thread.execption;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitCaught3 {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<?> future = exec.submit(new Task());
        exec.shutdown();
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("==Exception: " + e.getMessage());
        }

    }
}
