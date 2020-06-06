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
 * @create: 2020-05-26 11:03
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountTest {

    @Autowired
    private AccountService as;

    @Test
    public void testTansfer(){
        as.transfer("aaa","bbb",10f);
    }


}
