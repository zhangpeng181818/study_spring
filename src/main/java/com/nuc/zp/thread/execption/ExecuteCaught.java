package com.nuc.zp.thread.execption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 未捕获到异常
 */
public class ExecuteCaught {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        exec.execute(thread);
        exec.shutdown();
    }
}