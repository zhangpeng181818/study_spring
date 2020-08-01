package com.nuc.zp.aop;

import org.springframework.stereotype.Component;

@Component
public class User {

    public void add(int a, int b) {
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        int i = 2 / 0;
    }
}
