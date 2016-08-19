package io.github.yanglikun.aspectjStyle.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Aspect
@Component //这个@Component不能少，要不然spring不会加载这个类
//@Order(2)测试顺序的时候用
public class AspectExample {

    @Before("execution(* io.github.yanglikun.aspectjStyle.annotation.target.*.*(..))")
    public void beforeExecute1() {
        System.out.println("@Aspect.@Before.......1");
    }


    @Around("execution(* io.github.yanglikun.aspectjStyle.annotation.target.*.*(..))")
    public Object aroundExecute(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("@Aspect.@Around[before]");
        Object retVal = pjp.proceed();
        System.out.println("@Aspect.@Around[after|" + retVal + "]");
        return retVal;
    }


    @AfterThrowing(
            pointcut = "execution(* io.github.yanglikun.aspectjStyle.annotation.target.*.*(..))",
            throwing = "ex")
    public void afterThrowingExecute(RuntimeException ex) {
        System.out.println("@Aspect.@AfterThrowing[" + ex.getMessage() + "]");
    }

    @AfterReturning("execution(* io.github.yanglikun.aspectjStyle.annotation.target.*.*(..))")
    public void afterReturningExecute() {
        System.out.println("@Aspect.@AfterReturning");
    }

    @After("execution(* io.github.yanglikun.aspectjStyle.annotation.target.*.*(..))")
    public void afterFinallyExecute() {
        System.out.println("@Aspect.@After");
    }

}
