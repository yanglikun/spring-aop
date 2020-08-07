package io.github.yanglikun.interfaceorimpl.aop;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;

/**
 * @author yanglikun
 */
public class ExceptionAdvice implements ThrowsAdvice {

    public void afterThrowing(Method method, Object[] args, Object target, Throwable subclass) throws Throwable {
        //不会查找继承体系
        boolean dontNeedAdvice = method.isAnnotationPresent(NoExceptionAdiveAnno.class);
        //会查找继承体系
        NoExceptionAdiveAnno annotation = AnnotationUtils.findAnnotation(method, NoExceptionAdiveAnno.class);

        System.out.println("通过AnnotationUtils查找:" + (annotation != null));
        System.out.println("通过method查找:" + dontNeedAdvice);//如果用cg

        if (dontNeedAdvice) {
            //有注解什么也不做
        } else {
            throw new WrapException("这个是封装后的异常");
        }
    }

}
