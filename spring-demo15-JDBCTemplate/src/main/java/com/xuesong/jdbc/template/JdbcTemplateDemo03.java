package com.xuesong.jdbc.template;

import com.xuesong.dao.AccountDao;
import com.xuesong.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author: Snow
 * @create: 2020-06-01 17:55
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class JdbcTemplateDemo03 {

    @Autowired
    private AccountDao accountDao;

    @Test
    public void Test01(){
        Account accountByID = accountDao.findAccountByID(8);
        System.out.println(accountByID);
    }

    @Test
    public void Test02(){
        Account xixi = accountDao.findAccountByName("xixi");
        System.out.println(xixi);
    }
}
