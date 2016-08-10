package io.github.yanglikun.aspectjStyle.xml.target;

import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("userService")
public class UserServiceImpl implements UserService {

    public String queryAllUser() {
        System.out.println("queryAllUser");
        int i=1/0;
        return "querySuc";
    }

    public void saveUser() {
        System.out.println("saveUser");
    }

    public void updateUser() {
        System.out.println("updateUser");
    }
}
