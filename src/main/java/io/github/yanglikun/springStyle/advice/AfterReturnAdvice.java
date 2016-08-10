package io.github.yanglikun.springStyle.advice;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("afterReturnAdvice")
public class AfterReturnAdvice implements AfterReturningAdvice {

    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("AfterReturnAdvice[" + returnValue + "]");
    }

}
