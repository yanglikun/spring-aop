package io.github.yanglikun.interfaceorimpl.service.impl;

import io.github.yanglikun.interfaceorimpl.service.OrderServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author yanglikun
 */
@Service
public class MainService {

    @Autowired
    @Qualifier("orderService")
    private OrderServiceI orderServiceI;

    public void save() {
        System.out.println("orderServiceI:" + orderServiceI.getClass());
        orderServiceI.save();
    }

}
