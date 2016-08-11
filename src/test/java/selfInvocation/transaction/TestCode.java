package selfInvocation.transaction;

import io.github.yanglikun.selfInvocation.springTransaction.UserServiceNoI;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglikun on 2016/8/11.
 */
public class TestCode {

    @Test
    public void testTransaction() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("selfInvacation/spring-config-transaction.xml");
        UserServiceNoI userService = ctx.getBean("userService", UserServiceNoI.class);
        userService.saveUser();
    }

    /**
     * 嵌套没有事务
     */
    @Test
    public void testTransactionQueryAllUser(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("selfInvacation/spring-config-transaction.xml");
        UserServiceNoI userService = ctx.getBean("userService", UserServiceNoI.class);
        userService.queryAllUser();
    }

}
