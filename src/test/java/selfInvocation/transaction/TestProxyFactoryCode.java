package selfInvocation.transaction;

import io.github.yanglikun.selfInvocation.springTransaction.UserServiceNoI;
import io.github.yanglikun.selfInvocation.springTransaction.UserServiceNoI4ProxyFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglikun on 2016/8/11.
 */
public class TestProxyFactoryCode {

    @Test
    public void testTransaction() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("selfInvacation/spring-config-transaction-proxyfactorybean.xml");
        UserServiceNoI4ProxyFactory userService = ctx.getBean("templatesDAO", UserServiceNoI4ProxyFactory.class);
        userService.saveUser();
    }

    /**
     * 嵌套没有事务
     */
    @Test
    public void testTransactionQueryAllUser(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("selfInvacation/spring-config-transaction-proxyfactorybean.xml");
        UserServiceNoI4ProxyFactory userService = ctx.getBean("templatesDAO", UserServiceNoI4ProxyFactory.class);
        userService.queryAllUser();
    }

}
