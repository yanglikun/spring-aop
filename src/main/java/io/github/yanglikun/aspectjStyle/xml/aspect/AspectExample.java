package io.github.yanglikun.aspectjStyle.xml.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("aspectExample")
public class AspectExample {

    public void beforeExecute() {
        System.out.println("AspectExample.beforeExecute");
    }

    public Object aroundExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("AspectExample.beforeExecute[before]");
        Object retVal = pjp.proceed();
        System.out.println("AspectExample.aroundExecute[after|" + retVal + "]");
        return retVal;
    }

    public void afterThrowingExecute(RuntimeException ex) {
        System.out.println("AspectExample.afterThrowingExecute[" + ex.getMessage() + "]");
    }

    public void afterReturningExecute() {
        System.out.println("AspectExample.afterReturningExecute");
    }

    public void afterFinallyExecute() {
        System.out.println("AspectExample.afterFinallyExecute");
    }

}
