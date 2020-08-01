package com.nuc.zp.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

public class CGLIBProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(User.class);
        Persion persion = new Persion();
        enhancer.setCallback(persion);
        User user = (User) enhancer.create();
        user.add();
    }
}
