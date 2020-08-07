package io.github.yanglikun.interfaceorimpl.service;

import io.github.yanglikun.interfaceorimpl.aop.NoExceptionAdiveAnno;

/**
 * @author yanglikun
 */
public interface OrderServiceI {

    @NoExceptionAdiveAnno
    void save();

}
