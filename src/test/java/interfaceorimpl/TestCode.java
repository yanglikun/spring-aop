package interfaceorimpl;

import io.github.yanglikun.interfaceorimpl.service.OrderServiceI;
import io.github.yanglikun.interfaceorimpl.service.impl.MainService;
import io.github.yanglikun.interfaceorimpl.service.impl.OrderServiceImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author yanglikun
 */
public class TestCode {

    @Test
    public void testOrderService() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("interfaceorimpl/spring-aop-interfaceorimpl.xml");
        OrderServiceI orderServiceI = ctx.getBean(OrderServiceI.class);
        System.out.println("OrderServiceI:" + orderServiceI.getClass());
        orderServiceI.save();
    }

    /**
     * 这个会报错，因为proxy不是Impl的实例
     * com.sun.proxy.$Proxy10 cannot be cast to io.github.yanglikun.interfaceorimpl.service.impl.OrderServiceImpl
     */
    @Test
    public void testOrderServiceImpl() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("interfaceorimpl/spring-aop-interfaceorimpl.xml");
        OrderServiceImpl orderServiceImpl = (OrderServiceImpl) ctx.getBean("orderService");
        System.out.println("orderServiceImpl:" + orderServiceImpl.getClass());
        orderServiceImpl.save();
    }


    @Test
    public void testMainService() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("interfaceorimpl/spring-aop-interfaceorimpl.xml");
        MainService mainService = ctx.getBean(MainService.class);
        System.out.println("mainService:" + mainService.getClass());
        mainService.save();
    }

}
