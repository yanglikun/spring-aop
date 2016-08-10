package springStyle.declaration.manual;

import io.github.yanglikun.springStyle.target.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class TestCode {

    @Test
    @SuppressWarnings("Duplicates")
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("declaration/manual/spring-config.xml");
        UserService proxy = (UserService) ctx.getBean("userServiceProxy");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
        proxy.saveUser();
    }


    @Test
    @SuppressWarnings("Duplicates")
    public void testFilterMethod() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("declaration/manual/spring-config-filter-method.xml");
        UserService proxy = (UserService) ctx.getBean("userServiceProxy");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
        proxy.saveUser();
    }
}
