package io.github.yanglikun.proxy.cglib;

import net.sf.cglib.beans.BeanCopier;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.beans.BeanMap;
import net.sf.cglib.beans.BulkBean;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

public class BeanTest {

    /**
     * 创建一个javabean
     *
     * @throws Exception
     */
    @Test
    public void testBeanGenerator() throws Exception {
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("value", String.class);
        Object myBean = beanGenerator.create();

        Method setter = myBean.getClass().getMethod("setValue", String.class);
        setter.invoke(myBean, "Hello cglib!");
        Method getter = myBean.getClass().getMethod("getValue");
        System.out.println(getter.invoke(myBean));
    }

    @Test
    public void testBeanCopier() throws Exception {
        BeanCopier copier = BeanCopier.create(SampleBean.class, SampleBean2.class, false);
        SampleBean bean = new SampleBean();
        bean.setValue("Hello cglib!");
        SampleBean2 bean2 = new SampleBean2();
        copier.copy(bean, bean2, null);
        System.out.println(bean);
        System.out.println(bean2);
    }

    /**
     * 可以避免通过反射访问
     *
     * @throws Exception
     */
    @Test
    public void testBulkBean() throws Exception {
        BulkBean bulkBean = BulkBean.create(SampleBean.class,
                new String[]{"getValue", "getName"},
                new String[]{"setValue", "setName"},
                new Class[]{String.class, String.class});
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world!");

        System.out.println(Arrays.toString(bulkBean.getPropertyValues(bean)));

        bulkBean.setPropertyValues(bean, new Object[]{"Hello cglib!", "zs"});

        System.out.println(Arrays.toString(bulkBean.getPropertyValues(bean)));
    }

    /**
     * 把对象转换为map
     */
    @Test
    public void testBeanMap() {
        SampleBean bean = new SampleBean();
        bean.setValue("Hello cglib!");
        bean.setName("zhangsan");

        BeanMap beanMap = BeanMap.create(bean);
        beanMap.forEach((k, v) -> System.out.println(k + ":" + v));

        bean.setName("lisi");
        beanMap.forEach((k, v) -> System.out.println(k + ":" + v));
    }

}
