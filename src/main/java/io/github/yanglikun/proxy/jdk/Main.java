package io.github.yanglikun.proxy.jdk;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
        UserServiceInvocationHandler invocationHandler =
                new UserServiceInvocationHandler(new UserServiceImpl());

        UserService proxy = (UserService) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[]{UserService
                        .class},
                invocationHandler);

        proxy.save();
        proxy.count();
    }
}
