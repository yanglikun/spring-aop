package interfaceorimpl;

import io.github.yanglikun.interfaceorimpl.service.OrderServiceI;
import io.github.yanglikun.interfaceorimpl.service.impl.MainService;
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

    @Test
    public void testMainService() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("interfaceorimpl/spring-aop-interfaceorimpl.xml");
        MainService mainService = ctx.getBean(MainService.class);
        System.out.println("mainService:" + mainService.getClass());
        mainService.save();
    }

}
