package aspectjStyle.xml;

import io.github.yanglikun.aspectjStyle.xml.target.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class TestCode {

    @Test
    @SuppressWarnings("Duplicates")
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aspectjStyle/spring-config-xml.xml");
        UserService proxy = (UserService) ctx.getBean("userService");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
    }

}
