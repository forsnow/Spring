package com.xuesong.test;

import com.xuesong.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @description:
 * @author: Snow
 * @create: 2020-06-03 14:38
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class txTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void test01(){
        accountService.transfer("bbb","aaa",100f);
    }



}
