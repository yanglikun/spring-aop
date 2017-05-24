package springStyle.declaration.manual;

import io.github.yanglikun.springStyle.target.NoDefaultConstructorService;
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

    /**
     * 这个要切换到spring 4.0版本，要不然会报异常。     *
     * Caused by: java.lang.IllegalArgumentException: Superclass has no null constructors but no arguments were given
     * 原因如下：
     * http://blog.codeleak.pl/2014/07/spring-4-cglib-based-proxy-classes-with-no-default-ctor.html
     */
    @Test
    public void serviceNoDefaultConstructorTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("springStyle/declaration/manual/spring-config.xml");
        NoDefaultConstructorService proxy = (NoDefaultConstructorService) ctx.getBean("serviceNoDefaultConstructor");
        String ret = proxy.test("aaa");
        System.out.println("执行结果:" + ret);
    }

    /**
     * 这个也是无参构造函数因为使用了objenesis,所以使用spring4之前的也可以代理无参构造函数的类
     * 通过查看spring4也是使用了objenesis
     */
    @Test
    public void serviceNoDefaultConstructor2Test() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext
                ("springStyle/declaration/manual/spring-config.xml");
        NoDefaultConstructorService proxy = (NoDefaultConstructorService) ctx.getBean("serviceNoDefaultConstructor2");
        String ret = proxy.test("aaa");
        System.out.println("执行结果:" + ret);
    }
}
