package io.github.yanglikun.programmatic.advice;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class AfterThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method m, Object[] args, Object target, RuntimeException ex) {
        System.out.println("AfterThrowsAdvice[" + ex.getMessage() + "]");
    }
}
