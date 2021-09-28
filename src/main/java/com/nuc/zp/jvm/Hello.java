package com.nuc.zp.jvm;

public class Hello {

    volatile  int i;

    public void m(){
        System.out.println("Hello JVM!");
    }

    public static void main(String[] args) {
        Object o = new Object();
    }
}
