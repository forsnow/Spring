package com.xuesong.ui;

import com.xuesong.dao.AccountDao;
import com.xuesong.factory.BeanFactory;
import com.xuesong.service.AccountService;

/**
 * @author Snow
 * @Description：模拟一个表现层，去调用业务层
 * @date 2020/5/20-14:56
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            AccountService as = (AccountService)BeanFactory.getBean("AccountService");
            System.out.println(as);
            as.saveAccount();
        }
    }
}
