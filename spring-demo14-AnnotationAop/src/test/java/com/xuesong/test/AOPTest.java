package com.xuesong.test;


import com.xuesong.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: Snow
 * @create: 2020-05-29 16:21
 **/

public class AOPTest {
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.saveAccount();
    }
}
