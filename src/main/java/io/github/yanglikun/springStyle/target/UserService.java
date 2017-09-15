package io.github.yanglikun.springStyle.target;

/**
 * Created by yanglikun on 2016/8/10.
 */
public interface UserService {

    String queryAllUser();

    int saveUser(String pin);

    void updateUser();

}
