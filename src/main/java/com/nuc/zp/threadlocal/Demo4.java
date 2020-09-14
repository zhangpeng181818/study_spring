package com.nuc.zp.threadlocal;

public class Demo4 {
    private static InheritableThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("mainThread");
                String value = threadLocal.get();
                System.out.println("value:" + value);
            }
        });
        thread.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                String value = threadLocal.get();
                System.out.println("value2:" + value);
            }
        });
        thread2.start();

    }

}
