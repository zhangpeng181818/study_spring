package com.nuc.zp.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {

    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces = {UserDao.class};
        UserDao proxyInstance = (UserDao) Proxy.newProxyInstance(
                JDKProxy.class.getClassLoader(),
                interfaces,
                new UserProxy(new UserDaoImpl()));
        int add = proxyInstance.add(1, 2);
        System.out.println("result ：" + add);
    }
}

class UserProxy implements InvocationHandler {

    private Object object;

    public UserProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("方法执行之前" + method.getName() + " 方法参数：" + Arrays.toString(args));
        Object invoke = method.invoke(object, args);
        System.out.println("方法执行之后：" + invoke);
        return invoke;
    }
}