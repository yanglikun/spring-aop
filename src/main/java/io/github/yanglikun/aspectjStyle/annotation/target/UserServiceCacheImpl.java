package io.github.yanglikun.aspectjStyle.annotation.target;

import io.github.yanglikun.aspectjStyle.annotation.Cache;
import org.springframework.stereotype.Service;

/**
 * Created by yanglikun on 2016/8/15.
 */
@Service("userServiceCache")
public class UserServiceCacheImpl {

    public String queryAllUser() {
        return "张三";
    }

    @Cache("redis_key_queryAllUserWithCache")
    public String queryAllUserWithCache() {
        return "张三";
    }
}
