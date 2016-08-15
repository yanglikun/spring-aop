package io.github.yanglikun.aspectjStyle.annotation.aspect;

import io.github.yanglikun.aspectjStyle.annotation.Cache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/15.
 */
@Aspect
@Component
public class CacheAnnotationExample {

    @Around(value = "@annotation(cache)")
    public Object interceptMethod(ProceedingJoinPoint joinPoint, Cache cache) throws Throwable {
        String cacheValue = "李四";
        if (cacheValue != null && !cacheValue.isEmpty()) {
            return cache.value() + cacheValue;
        } else {
            return joinPoint.proceed();
        }
    }

}
