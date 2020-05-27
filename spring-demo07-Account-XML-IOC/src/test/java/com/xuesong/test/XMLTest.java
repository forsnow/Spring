package com.xuesong.test;

import com.xuesong.domain.Account;
import com.xuesong.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @description:
 * @author: Snow
 * @create: 2020-05-26 11:03
 **/
public class XMLTest {

    @Test
    public void TestfindAllAccount(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService",AccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void TestfindAccountByID(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        Account accountByID = accountService.findAccountByID(2);
        System.out.println(accountByID);

    }

    @Test
    public void TestsaveAccount(){
        Account account = new Account();
        account.setName("kk");
        account.setMoney(20000f);

        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.saveAccount(account);

    }

    @Test
    public void TestdeleteAccount(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.deleteAccount(4);
    }


}
