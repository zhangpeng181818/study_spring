package com.nuc.zp.thread.execption;


public class WitchCaughtThread {
    public static void main(String args[]) {
        Thread thread = new Thread(new Task());
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }
}

