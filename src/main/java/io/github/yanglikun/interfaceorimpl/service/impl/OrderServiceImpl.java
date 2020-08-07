package io.github.yanglikun.interfaceorimpl.service.impl;

import io.github.yanglikun.interfaceorimpl.service.OrderServiceI;
import org.springframework.stereotype.Service;

/**
 * @author yanglikun
 */
@Service("orderService")
public class OrderServiceImpl implements OrderServiceI {

    @Override
    public void save() {
        System.out.println("开始保存");
        int i = 1 / 0;
    }

}
