package io.github.yanglikun.proxy.jdk;

public class UserServiceImpl implements UserService {

    @Override
    public int count() {
        System.out.println("userService.count数量");
        return 3;
    }

    @Override
    public void save(String name,int age) {
        System.out.println("userService.save保存");
    }
}
