package springStyle.Programmatic;

import io.github.yanglikun.programmatic.advice.AfterReturnAdvice;
import io.github.yanglikun.programmatic.advice.AfterThrowsAdvice;
import io.github.yanglikun.programmatic.advice.AroundAdvice;
import io.github.yanglikun.programmatic.advice.BeforeAdvice;
import io.github.yanglikun.programmatic.target.UserService;
import io.github.yanglikun.programmatic.target.UserServiceImpl;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class TestCode {

    @Test
    public void testProgrammatic() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new UserServiceImpl());
        proxyFactory.addAdvice(new BeforeAdvice());
        UserService proxy = (UserService) proxyFactory.getProxy();
        proxy.queryAllUser();
        proxy.saveUser();
    }


    @Test
    public void testAdvice() {
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(new UserServiceImpl());

        proxyFactory.addAdvice(new BeforeAdvice());
        proxyFactory.addAdvice(new AroundAdvice());
        proxyFactory.addAdvice(new AfterThrowsAdvice());
        proxyFactory.addAdvice(new AfterReturnAdvice());

        UserService proxy = (UserService) proxyFactory.getProxy();
        String s = proxy.queryAllUser();
        System.out.println("执行结果:" + s);
    }
}
