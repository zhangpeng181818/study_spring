package com.nuc.zp.thread.execption;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SubmitCaught {

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new Task());
        exec.shutdown();

    }
}
