package com.nuc.zp.thread.execption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteCaught2 {

    public static void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ThreadPoolTask());
        exec.shutdown();
    }
}
