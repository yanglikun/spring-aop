package selfInvocation.spring;

import io.github.yanglikun.selfInvocation.spring.target.UserServiceNoI;
import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Method;

/**
 * Created by yanglikun on 2016/8/11.
 */
public class TestCode {

    @Test
    public void testSpring() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("selfInvacation/spring-config-spring.xml");
        UserServiceNoI userService = ctx.getBean("userService", UserServiceNoI.class);
        System.out.println(userService.getClass());
        userService.queryAllUser();
        System.out.println("====单独调用save开始======");
        userService.saveUser();
    }

    /**
     * 开始没有self-invocation问题
     */
    @Test
    public void testCglib() {
        UserServiceNoI userServiceNoI = (UserServiceNoI) Enhancer.create(UserServiceNoI.class, new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("开始事务");
                Object o1 = methodProxy.invokeSuper(o, objects);
                System.out.println("结束事务");
                return o1;
            }
        });
        System.out.println(userServiceNoI.getClass());
        userServiceNoI.queryAllUser();
        System.out.println("====单独调用save开始======");
        userServiceNoI.saveUser();
    }

}
