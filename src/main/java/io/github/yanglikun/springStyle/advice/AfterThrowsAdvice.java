package io.github.yanglikun.springStyle.advice;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("afterThrowsAdvice")
public class AfterThrowsAdvice implements ThrowsAdvice {

    public void afterThrowing(Method m, Object[] args, Object target, RuntimeException ex) {
        System.out.println("AfterThrowsAdvice[" + ex.getMessage() + "]");
    }
}
