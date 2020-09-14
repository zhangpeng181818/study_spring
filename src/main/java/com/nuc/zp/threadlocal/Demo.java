package com.nuc.zp.threadlocal;

public class Demo {

    private String content;

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static void main(String[] args) {

        Demo demo = new Demo();
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
