package io.github.yanglikun.programmatic.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class AroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("AroundAdvice[before]");
        Object ret=invocation.proceed();
        System.out.println("AroundAdvice[after|"+ret+"]");
        return ret;
    }
}
