package io.github.yanglikun.proxy.cglib;

import com.sun.org.apache.xpath.internal.SourceTree;

public class SampleClass {

    public SampleClass() {
        System.out.println("sampleClass构造函数");
    }

    public static String staticTest() {
        return "hello world static!";
    }

    public String test() {
        return "hello world!" + ":this:" +this;
    }

    public final String finalTest() {
        return "hello world final!"+ ":this:"+this;
    }

    public int getAge() {
        return 10;
    }

}
