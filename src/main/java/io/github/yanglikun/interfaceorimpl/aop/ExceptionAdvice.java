package io.github.yanglikun.interfaceorimpl.aop;

import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * @author yanglikun
 */
public class ExceptionAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Throwable subclass) throws Throwable {
        boolean dontNeedAdvice = method.isAnnotationPresent(NoExceptionAdiveAnno.class);
        if (dontNeedAdvice) {
            //有注解什么也不做
        } else {
            throw new WrapException("这个是封装后的异常");
        }
    }

}
