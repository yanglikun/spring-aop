package io.github.yanglikun.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserServiceInvocationHandler implements InvocationHandler {

    private UserService userService;


    public UserServiceInvocationHandler(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理拦截-before");
        Object invoke = method.invoke(userService, args);
        System.out.println("动态代理拦截-after:" + invoke);
        return invoke;
    }

}
