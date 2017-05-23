package springStyle.declaration.manual;

import io.github.yanglikun.springStyle.target.UserService;
import io.github.yanglikun.springStyle.target.UserServiceNoInterface;
import io.github.yanglikun.springStyle.target.notorigin.OriginService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class TestCode {

    @Test
    @SuppressWarnings("Duplicates")
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("springStyle/declaration/manual/spring-config.xml");
        UserService proxy = (UserService) ctx.getBean("userServiceProxy");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
        proxy.saveUser("zhangsan");
    }


    @Test
    @SuppressWarnings("Duplicates")
    public void testFilterMethod() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("springStyle/declaration/manual/spring-config-filter-method.xml");
        UserService proxy = (UserService) ctx.getBean("userServiceProxy");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
        proxy.saveUser("zhangsan");
    }

    @Test
    @SuppressWarnings("Duplicates")
    public void userServiceNoInterfaceProxy() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("springStyle/declaration/manual/spring-config.xml");
        UserServiceNoInterface proxy = (UserServiceNoInterface) ctx.getBean("userServiceNoInterfaceProxy");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
        proxy.saveUser("zhangsan");
    }

    @Test
    public void notCallOrigin() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("springStyle/declaration/manual/spring-config.xml");
        OriginService proxy = (OriginService) ctx.getBean("notCallOrigin");
        String ret = proxy.test(1, "eee");
        System.out.println("执行结果:" + ret);
    }
}
