package com.xuesong.test;

import com.xuesong.config.SpringConfiguration;
import com.xuesong.domain.Account;
import com.xuesong.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

/**
 * @description:
 * @author: Snow
 * @create: 2020-05-26 11:03
 **/

/**
 * 使用Junit单元测试，测试我们的配置
 * Spring整合Junit的配置
 * 1.导入Spring整合junit的jar（Spring-test坐标）
 * 2.使用Junit提供的一个注解把原油的main方法替换了，替换成Spring提供的
 * 3.告知Spring的运行器，Spring和IOC是基于注解的还是XML的，并且说明位置信息
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
public class AnnotationTest {

    @Test
    public void TestfindAllAccount(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = ac.getBean("accountService",AccountService.class);
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void TestfindAccountByID(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        Account accountByID = accountService.findAccountByID(2);
        System.out.println(accountByID);

    }

    @Test
    public void TestsaveAccount(){
        Account account = new Account();
        account.setName("uu");
        account.setMoney(2000f);

        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.saveAccount(account);

    }

    @Test
    public void TestdeleteAccount(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        accountService.deleteAccount(4);
    }


}
