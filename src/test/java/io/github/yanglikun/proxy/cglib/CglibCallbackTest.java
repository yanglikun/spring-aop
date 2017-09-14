package io.github.yanglikun.proxy.cglib;

import static org.junit.Assert.*;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Dispatcher;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.InvocationHandler;
import net.sf.cglib.proxy.LazyLoader;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import net.sf.cglib.proxy.NoOp;
import net.sf.cglib.proxy.ProxyRefDispatcher;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 参考文章：
 * http://mydailyjava.blogspot.hk/2013/11/cglib-missing-manual.html
 * <p>
 * http://jnb.ociweb.com/jnb/jnbNov2005.html
 */
public class CglibCallbackTest {

    @Test
    public void testFixedValue() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((FixedValue) () -> "hello cglib");
        //使用enhancer.create创建对象
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("testFixedValue：" + proxy.getClass().getName());
        System.out.println("proxy.test：" + proxy.test());
        System.out.println("proxy.toString：" + proxy.toString());
        //java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Number
        //System.out.println("proxy.hashCode：" + proxy.hashCode());

        //final method 不会代理
        System.out.println("proxy.finalTest：" + proxy.finalTest());
        //static method 不会代理
        System.out.println("proxy.staticTest：" + proxy.staticTest());

    }

    /**
     * InvocationHandler和jdk动态代理一样，不能调用到父类方法，
     * 如果要调用父类方法要用MethodInterceptor
     *
     * @throws Exception
     */
    @Test
    public void testInvocationHandler() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(
                (InvocationHandler) (proxy, method, args) -> {
                    if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                        return "Hello cglib!";
                    } else {
                        throw new RuntimeException("Do not know what to do.");
                    }
                }
        );
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("proxy.test：" + proxy.test());
        System.out.println("proxy.toString：" + proxy.toString());
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(
                (MethodInterceptor) (obj, method, args, proxyMethod) -> {
                    if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                        return "Hello cglib!";
                    } else {
                        return proxyMethod.invokeSuper(obj, args);
                    }
                }
        );
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("proxy.class：" + proxy.getClass().getName());
        System.out.println("proxy.test：" + proxy.test());
        System.out.println("proxy.toString：" + proxy.toString());
        System.out.println("proxy.hashCode：" + proxy.hashCode());
        System.out.println("proxy.getAge：" + proxy.getAge());
    }

    /**
     * 会缓存创建的对象
     */
    @Test
    public void testLazyLoader() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((LazyLoader) () -> new SampleClass());
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("proxy.class：" + proxy.getClass().getName());
        System.out.println("proxy.test：" + proxy.test());
        System.out.println("proxy.toString：" + proxy.toString());
        System.out.println("proxy.hashCode：" + proxy.hashCode());
        System.out.println("proxy.getAge：" + proxy.getAge());
    }


    /**
     * 每次都会创建代理对象
     */
    @Test
    public void testLazyDispatcher() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((Dispatcher) () -> new SampleClass());
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("proxy.class：" + proxy.getClass().getName());
        System.out.println("proxy.test：" + proxy.test());
        System.out.println("proxy.toString：" + proxy.toString());
        System.out.println("proxy.hashCode：" + proxy.hashCode());
        System.out.println("proxy.getAge：" + proxy.getAge());
    }

    /**
     * 可获取proxy对象
     */
    @Test
    public void testProxyRefDispatcher() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback((ProxyRefDispatcher) (Object proxy) -> {
            return new SampleClass();
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("proxy.getAge：" + proxy.getAge());
    }

    /**
     * 没有拦截操作，直接调用被代理对象
     */
    @Test
    public void testNoOp() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallback(new NoOp() {
        });
        SampleClass proxy = (SampleClass) enhancer.create();
        System.out.println("proxy.getAge：" + proxy.getAge());
    }

    /**
     * callbacks和MethodInterceptor实现的功能差不多，不过分开写拦截的逻辑
     *
     * @throws Exception
     */
    @Test
    public void testCallbackFilter() throws Exception {
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if (method.getDeclaringClass() != Object.class && method.getReturnType() == String.class) {
                    return (FixedValue) () -> "Hello cglib!";
                } else {
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass) enhancer.create();
        assertEquals("Hello cglib!", proxy.test());
        assertNotEquals("Hello cglib!", proxy.toString());
        proxy.hashCode();
    }
}