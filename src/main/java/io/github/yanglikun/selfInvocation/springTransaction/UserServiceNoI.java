package io.github.yanglikun.selfInvocation.springTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yanglikun on 2016/8/11.
 * 数据库创建语句<br/>
 * <b>
 * CREATE TABLE `t` (
 * `id` INT(11) NOT NULL AUTO_INCREMENT,
 * `name` VARCHAR(50) NULL DEFAULT NULL,
 * PRIMARY KEY (`id`)
 * )
 * COLLATE='utf8_general_ci'
 * ENGINE=InnoDB
 * </b>
 */
@Component("userService")
public class UserServiceNoI {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void queryAllUser() {
        System.out.println("查询用户");
        saveUser();
    }

    @Transactional
    public void saveUser() {
        jdbcTemplate.execute("insert into t(name) values('zs')");
        int i = 1 / 0;
        jdbcTemplate.execute("insert into t(name) values('ls')");
    }


}
