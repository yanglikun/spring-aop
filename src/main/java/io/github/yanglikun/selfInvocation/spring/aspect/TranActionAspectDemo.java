package io.github.yanglikun.selfInvocation.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/11.
 */
@Aspect
@Component
public class TranActionAspectDemo {

    @Around("execution(* io.github.yanglikun.selfInvocation.spring.target.*.save*(..))")
    public Object aroundExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("TranActionAspectDemo.开启事务");
        Object retVal = pjp.proceed();
        System.out.println("TranActionAspectDemo.关闭事务");
        return retVal;
    }
}
