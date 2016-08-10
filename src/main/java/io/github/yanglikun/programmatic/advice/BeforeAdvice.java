package io.github.yanglikun.programmatic.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class BeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("BeforeAdvice");
    }

}
