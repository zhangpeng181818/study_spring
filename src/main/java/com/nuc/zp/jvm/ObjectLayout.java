package com.nuc.zp.jvm;

import org.openjdk.jol.info.ClassLayout;

public class ObjectLayout {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        Thread.sleep(5000);

        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
        }
    }
}
