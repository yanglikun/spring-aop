package aspectjStyle.annotation;

import io.github.yanglikun.aspectjStyle.annotation.target.UserService;
import io.github.yanglikun.aspectjStyle.annotation.target.UserServiceCacheImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yanglikun on 2016/8/10.
 */
public class TestCode {

    @Test
    @SuppressWarnings("Duplicates")
    public void test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aspectjStyle/spring-config-annotation.xml");
        UserService proxy = (UserService) ctx.getBean("userService");
        String ret = proxy.queryAllUser();
        System.out.println("执行结果:" + ret);
    }

    @Test
    @SuppressWarnings("Duplicates")
    public void testCache() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("aspectjStyle/spring-config-annotation.xml");
        UserServiceCacheImpl proxy = (UserServiceCacheImpl) ctx.getBean("userServiceCache");
        String ret = proxy.queryAllUser();
        System.out.println("queryAllUser:" + ret);

        String retCache = proxy.queryAllUserWithCache();
        System.out.println("queryAllUserWithCache:" + retCache);
    }

}
