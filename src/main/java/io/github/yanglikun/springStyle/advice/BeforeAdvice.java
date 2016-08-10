package io.github.yanglikun.springStyle.advice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("beforeAdvice")
public class BeforeAdvice implements MethodBeforeAdvice {

    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("BeforeAdvice");
    }

}
