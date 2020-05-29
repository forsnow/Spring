package com.xuesong.service.imp;

import com.xuesong.service.AccountService;

/**
 * @description:账户的业务层实现类
 * @author: Snow
 * @create: 2020-05-29 15:17
 **/
public class AccountServiceImp implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行了保存");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新"+i);
    }

    @Override
    public int deleteAccount() {
        System.out.println("执行了删除");
        return 0;
    }
}
