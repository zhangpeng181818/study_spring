package com.nuc.zp.threadlocal;

public class Demo3 {

    private ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public void setContent(String content) {
        threadLocal.set(content);
    }

    public String getContent() {
        return threadLocal.get();
    }

    public static void main(String[] args) {

        Demo3 demo = new Demo3();
        for (int i = 0; i < 5; i++) {

            Thread thread = new Thread(() -> {
                demo.setContent(Thread.currentThread().getName() + "的数据");
                System.out.println("-----------------------");
                System.out.println(Thread.currentThread().getName() + "---->" + demo.getContent());
            });

            thread.setName("线程" + i);
            thread.start();
        }

    }
}
