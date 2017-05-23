package io.github.yanglikun.springStyle.advice.notorigin;

import io.github.yanglikun.springStyle.target.notorigin.OriginService;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class NotOriginAroundAdvice implements MethodInterceptor {

    private OriginService realService;

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("拦截器不调用原始类");
        return invocation.getMethod().invoke(realService, invocation.getArguments());
    }

    public void setRealService(OriginService realService) {
        this.realService = realService;
    }
}
