package io.github.yanglikun.proxy.cglib;

import net.sf.cglib.beans.ImmutableBean;
import org.junit.Test;

public class ImmutableBeanTest {


    /**
     * 调用immutableBean的set方法会抛出异常
     * 原始bean修改会影响immutableBean
     *
     * @throws Exception
     */
    @Test
    public void testImmutableBean() throws Exception {
        SampleBean bean = new SampleBean();
        bean.setValue("Hello world!");
        SampleBean immutableBean = (SampleBean) ImmutableBean.create(bean);

        System.out.println("bean.getValue：" + bean.getValue());
        System.out.println("immutableBean.getValue：" + immutableBean.getValue());

        bean.setValue("Hello world, again!");

        System.out.println("bean.getValue：" + bean.getValue());
        System.out.println("immutableBean.getValue：" + immutableBean.getValue());

        //java.lang.IllegalStateException: Bean is immutable
        immutableBean.setValue("Hello cglib!");
    }


}
