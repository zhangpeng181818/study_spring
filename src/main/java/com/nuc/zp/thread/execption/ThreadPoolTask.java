package com.nuc.zp.thread.execption;

public class ThreadPoolTask implements Runnable
{
    @Override
    public void run()
    {
        Thread.currentThread().setUncaughtExceptionHandler(new ExceptionHandler());
        System.out.println(3/2);
        System.out.println(3/0);
        System.out.println(3/1);
    }
}
