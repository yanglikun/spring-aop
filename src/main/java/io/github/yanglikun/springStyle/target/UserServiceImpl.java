package io.github.yanglikun.springStyle.target;

import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("userService")
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("userService构造函数");
    }

    public String queryAllUser() {
        System.out.println("queryAllUser");
//        int i=1/0;
        return "querySuc";
    }

    public int saveUser(String pin) {
        System.out.println("saveUser:"+pin);
        return 3;
    }

    public void updateUser() {
        System.out.println("updateUser");
    }
}
