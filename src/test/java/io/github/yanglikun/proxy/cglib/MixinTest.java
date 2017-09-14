package io.github.yanglikun.proxy.cglib;

import io.github.yanglikun.proxy.cglib.mixin.Class1;
import io.github.yanglikun.proxy.cglib.mixin.Class2;
import io.github.yanglikun.proxy.cglib.mixin.Interface1;
import io.github.yanglikun.proxy.cglib.mixin.Interface2;
import io.github.yanglikun.proxy.cglib.mixin.MixinInterface;
import net.sf.cglib.proxy.Mixin;
import org.junit.Test;

public class MixinTest {

    @Test
    public void testMixin() throws Exception {
        Mixin mixin = Mixin.create(new Class[]{Interface1.class, Interface2.class,
                MixinInterface.class}, new Object[]{new Class1(), new Class2()});
        MixinInterface mixinDelegate = (MixinInterface) mixin;
        System.out.println(mixinDelegate.first());
        System.out.println(mixinDelegate.second());
    }
}
