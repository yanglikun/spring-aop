package io.github.yanglikun.springStyle.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("aroundAdvice")
public class AroundAdvice implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("AroundAdvice[before]");
        Object ret=invocation.proceed();
        System.out.println("AroundAdvice[after|"+ret+"]");
        return ret;
    }
}
