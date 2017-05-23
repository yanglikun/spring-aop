package io.github.yanglikun.springStyle.target.notorigin;

/**
 * Created by yanglikun on 2017/5/23.
 */
public class OriginService {

    private String name;

    public String test(int a, String b) {
        System.out.println("调用:" + name);
        return "service:" + name + ",a=" + a + ",b=" + b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
