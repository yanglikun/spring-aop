package io.github.yanglikun.springStyle.target;

/**
 * Created by yanglikun on 2017/5/24.
 */
public class ServiceNoDefaultConstructor {

    public ServiceNoDefaultConstructor(String str) {
        System.out.println("没有无参构造函数.str:" + str);
    }

    public String test(String value) {
        System.out.println("ServiceNoDefaultConstructor.test.exec...");
        return "ServiceNoDefaultConstructor->" + value;
    }
}
