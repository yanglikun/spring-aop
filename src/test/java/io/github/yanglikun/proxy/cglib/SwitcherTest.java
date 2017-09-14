package io.github.yanglikun.proxy.cglib;

import net.sf.cglib.util.StringSwitcher;
import org.junit.Test;

public class SwitcherTest {

    @Test
    public void testStringSwitcher() throws Exception {
        String[] strings = new String[]{"one", "two"};
        int[] values = new int[]{10, 20};
        StringSwitcher stringSwitcher = StringSwitcher.create(strings, values, true);

        System.out.println(stringSwitcher.intValue("one"));
        System.out.println(stringSwitcher.intValue("two"));
        System.out.println(stringSwitcher.intValue("three"));

    }

}
