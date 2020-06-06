package com.xuesong.jdbc.template;

import com.xuesong.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @description:JdbcTemplate的基本用法
 * @author: Snow
 * @create: 2020-05-31 15:09
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTemplateDemo02 {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void Test01(){
        jdbcTemplate.execute("insert into account(name,money) values ('xixi',1000)");
    }

    //保存
    @Test
    public void save(){
        jdbcTemplate.update("insert into account(name,money) values (?,?)","songsong",3333f);
    }
    //更新
    @Test
    public void update(){
        jdbcTemplate.update("update account set name = ?,money=? where id = ?","xuexue",5,9);
    }
    //删除
    @Test
    public void delete(){
        jdbcTemplate.update("delete from account where id = ?",9);
    }
    //查询所有
    @Test
    public void selectAll01(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new AccountRowMapper());
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    //查询所有 Spring封装的结果集
    @Test
    public void selectAll02(){
        List<Account> accountList = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : accountList) {
            System.out.println(account);
        }
    }

    //查询一个
    @Test
    public void selectOne(){
        List<Account> accountList = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 9);
        System.out.println(accountList.isEmpty()?"没有内容":accountList.get(0));
    }

    //查询返回一行一列（使用聚合函数，但不加group by子句）
    @Test
    public void count(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account", Long.class);
        System.out.println(aLong);
    }

}

class AccountRowMapper implements RowMapper<Account> {
    /**
     * @Description: 把结果集中的数据封装到Account中，然后由Spring把每个Account加到集合中d
     * @Param: [resultSet, i]
     * @Return: java.lang.Object
     * @Author: Snow
    **/
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setMoney(resultSet.getFloat("money"));
        account.setName(resultSet.getString("name"));
        return account;
    }
}



