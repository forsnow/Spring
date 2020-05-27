package com.xuesong.service.imp;

import com.xuesong.service.AccountService;

/**
 * 账户业务实现层
 * @author Snow
 * @date 2020/5/20-14:21
 */
public class AccountServiceImp implements AccountService {

    public AccountServiceImp() {
        System.out.println("对象创建了");
    }

    public void init() {
        System.out.println("对象初始化了");
    }

    @Override
    public void saveAccount() {
        System.out.println("AccountService的方法执行了");
    }

    public void destroy() {
        System.out.println("对象销毁了");
    }
}
