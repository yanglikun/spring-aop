package org.springframework.aop.framework;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.objenesis.ObjenesisException;
import org.objenesis.ObjenesisStd;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.Factory;

/**
 * Created by yanglikun on 2017/5/24.
 */
public class ObjenesisCglibAopProxy extends CustomCglibAopProxy{

    private static final Log logger = LogFactory.getLog(org.springframework.aop.framework.ObjenesisCglibAopProxy.class);

    private final ObjenesisStd objenesis;


    /**
     * Creates a new {@link org.springframework.aop.framework.ObjenesisCglibAopProxy} using the given {@link AdvisedSupport}.
     * @param config must not be {@literal null}.
     */
    public ObjenesisCglibAopProxy(AdvisedSupport config) {
        super(config);
        this.objenesis = new ObjenesisStd(true);
    }


    @Override
    @SuppressWarnings("unchecked")
    protected Object createProxyClassAndInstance(Enhancer enhancer, Callback[] callbacks) {
        try {
            Factory factory = (Factory) objenesis.newInstance(enhancer.createClass());
            factory.setCallbacks(callbacks);
            return factory;
        }
        catch (ObjenesisException ex) {
            // Fallback to Cglib on unsupported JVMs
            if (logger.isDebugEnabled()) {
                logger.debug("Unable to instantiate proxy using Objenesis, falling back "
                        + "to regular proxy construction", ex);
            }
            return super.createProxyClassAndInstance(enhancer, callbacks);
        }
    }
}
