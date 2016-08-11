package io.github.yanglikun.selfInvocation.spring.target;

import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/11.
 */
@Component("userService")
public class UserServiceNoI {


    public UserServiceNoI(){
        System.out.println("构造函数。。。");
    }

    public void queryAllUser() {
        System.out.println("查询用户");
        saveUser();
    }

    public void saveUser() {
        System.out.println("保存用户");
    }
}
