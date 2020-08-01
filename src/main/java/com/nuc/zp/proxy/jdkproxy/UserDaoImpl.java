package com.nuc.zp.proxy.jdkproxy;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public String get(String id) {
        return id;
    }
}
