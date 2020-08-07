package io.github.yanglikun.interfaceorimpl.aop;

import java.lang.annotation.*;

/**
 * @author yanglikun
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface NoExceptionAdiveAnno {
}
