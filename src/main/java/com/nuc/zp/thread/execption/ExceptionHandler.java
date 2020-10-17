package com.nuc.zp.thread.execption;

public class ExceptionHandler implements Thread.UncaughtExceptionHandler
{
    @Override
    public void uncaughtException(Thread t, Throwable e)
    {
        System.out.println("==Exception: "+e.getMessage());
    }
}
