package com.xuesong.test;

import com.xuesong.config.SpringConfiguration;
import com.xuesong.domain.Account;
import com.xuesong.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
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
 * @ContextConfiguration
 *         location:指定xml文件的位置，加上classpath关键字，表示在类的路径下面
 *         classes:指定注解类的位置
 *
 * 当使用Spring5.x版本的时候 junit版本必须是4.12以上
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AnnotationTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void TestfindAllAccount(){

        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void TestfindAccountByID(){

        Account accountByID = accountService.findAccountByID(2);
        System.out.println(accountByID);

    }

    @Test
    public void TestsaveAccount(){
        Account account = new Account();
        account.setName("uu");
        account.setMoney(2000f);

        accountService.saveAccount(account);

    }

    @Test
    public void TestdeleteAccount(){

        accountService.deleteAccount(4);
    }


}
