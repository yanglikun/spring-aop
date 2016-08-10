package io.github.yanglikun.programmatic.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class AfterReturnAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturnAdvice[" + returnValue + "]");
    }

}
