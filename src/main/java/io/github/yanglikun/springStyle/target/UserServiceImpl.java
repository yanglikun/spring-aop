package io.github.yanglikun.springStyle.target;

import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("userService")
public class UserServiceImpl implements UserService {

    public String queryAllUser() {
        System.out.println("queryAllUser");
//        int i=1/0;
        return "querySuc";
    }

    public void saveUser(String pin) {
        System.out.println("saveUser:"+pin);
    }

    public void updateUser() {
        System.out.println("updateUser");
    }
}
