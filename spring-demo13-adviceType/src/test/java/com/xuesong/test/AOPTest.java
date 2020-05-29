package com.xuesong.test;


import com.xuesong.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author: Snow
 * @create: 2020-05-29 16:21
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AOPTest {
    @Autowired
    private AccountService as;

    @Test
    public void test01(){
        as.saveAccount();
    }
}
