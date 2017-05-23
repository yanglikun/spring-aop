package springStyle.declaration.auto;

import io.github.yanglikun.springStyle.target.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class TestCode {

    @Test
    @SuppressWarnings("Duplicates")
    public void testAutoBeanName() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springStyle/declaration/auto/spring-config-bean-name.xml");
        UserService proxy = (UserService) ctx.getBean("userService");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
        proxy.saveUser("zhangsan");
    }

    @Test
    @SuppressWarnings("Duplicates")
    public void testAutoAdvisor() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springStyle/declaration/auto/spring-config-advisor.xml");
        UserService proxy = (UserService) ctx.getBean("userService");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
        proxy.saveUser("zhangsan");
    }
}
