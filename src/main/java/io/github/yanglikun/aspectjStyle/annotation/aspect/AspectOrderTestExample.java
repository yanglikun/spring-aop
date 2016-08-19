package io.github.yanglikun.aspectjStyle.annotation.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Aspect
@Component //这个@Component不能少，要不然spring不会加载这个类
//@Order(1) 测试顺序的时候用
public class AspectOrderTestExample {

    @Before("execution(* io.github.yanglikun.aspectjStyle.annotation.target.*.*(..))")
    public void beforeExecute1() {
        System.out.println("@Aspect.@Before.......higher");
    }

}
