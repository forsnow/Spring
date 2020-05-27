package com.xuesong.ui;

import com.xuesong.service.AccountService;
import com.xuesong.service.imp.AccountServiceImp;
import com.xuesong.service.imp.AccountServiceImp2;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.Date;

/**
 * @author Snow
 * @Description：模拟一个表现层，去调用业务层
 * @date 2020/5/20-14:56
 */
public class Client {
    /*原始方法new对象*/
    @Test
    public void Test01(){
        AccountService as = new AccountServiceImp2();
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
        AccountService accountService = (AccountService) ac.getBean("AccountService");
        accountService.saveAccount();
    }

    @Test
    public void TestSetInjection(){
        //获取核心容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //根据id获取bean对象
        AccountService accountService = (AccountService) ac.getBean("AccountService2");
        accountService.saveAccount();
    }

    /*复杂类型的注入/集合类型的注入*/
    @Test
    public void TestOtherInjection(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("AccountService3");
        accountService.saveAccount();
    }


}
