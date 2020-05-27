package com.xuesong.ui;

import com.xuesong.dao.AccountDao;
import com.xuesong.service.AccountService;
import com.xuesong.service.imp.AccountServiceImp;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Snow
 * @Description：模拟一个表现层，去调用业务层
 * @date 2020/5/20-14:56
 */
public class Client {
    /*原始方法new对象*/
    @Test
    public void Test01(){
        AccountService as = new AccountServiceImp();
        as.saveAccount();
    }

    /*spring IOC 把创建对象的权利交给框架*/
    /**
     * @Description: 获取spring的IOC核心容器,并根据id创建对象
     * @Param: []
     * @Return: void
     * @Author: Snow
     * @Date: 2020/5/22
    **/
    @Test
    public void TestApplicationContext(){
        //获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.saveAccount();
    }

    @Test
    public void testDao(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = (AccountDao) ac.getBean("accountDao");
        accountDao.saveAccount();
    }
    @Test
    public void testAutoWired(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount();
    }

    @Test
    public void testScope(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService as1 = (AccountService) ac.getBean("accountService");
        AccountService as2 = (AccountService) ac.getBean("accountService");
        System.out.println(as1 == as2);

    }


}
