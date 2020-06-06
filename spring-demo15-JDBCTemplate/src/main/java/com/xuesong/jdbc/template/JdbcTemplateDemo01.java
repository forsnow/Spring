package com.xuesong.jdbc.template;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * @description:JdbcTemplate的基本用法
 * @author: Snow
 * @create: 2020-05-31 15:09
 **/
public class JdbcTemplateDemo01 {

    @Test
    public void Test01(){
        //准备数据源，Spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/spring?useUnicode=true&characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("123456");

        //1.创建JdbcTemplate对象
        JdbcTemplate jdbcTemplate01 = new JdbcTemplate();
        //给jt设置数据源
        jdbcTemplate01.setDataSource(ds);
        //2.执行操作
        jdbcTemplate01.execute("insert into account(name,money) values ('haha',1000)");
    }
}
