package io.github.yanglikun.springStyle.target;

import org.springframework.stereotype.Component;

/**
 * Created by yanglikun on 2016/8/10.
 */
@Component("userServiceNoInterface")
public class UserServiceNoInterface{

    public String queryAllUser() {
        System.out.println("userServiceNoInterface-queryAllUser");
//        int i=1/0;
        return "userServiceNoInterface-querySuc";
    }

    public void saveUser(String pin) {
        System.out.println("userServiceNoInterface-saveUser:"+pin);
    }

    public void updateUser() {
        System.out.println("userServiceNoInterface-updateUser");
    }
}
