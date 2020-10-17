package com.nuc.zp.thread.execption;

public class WitchCaughtThread2 {
    public static void main(String args[])
    {
        Thread.setDefaultUncaughtExceptionHandler(new ExceptionHandler());
        Thread thread = new Thread(new Task());
        thread.start();
    }
}
