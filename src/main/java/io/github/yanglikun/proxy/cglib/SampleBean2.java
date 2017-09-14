package io.github.yanglikun.proxy.cglib;

public class SampleBean2 {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SampleBean2{");
        sb.append("value='").append(value).append('\'');
        sb.append('}');
        return sb.toString();
    }
}