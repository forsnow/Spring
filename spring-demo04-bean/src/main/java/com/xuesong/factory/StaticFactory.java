package com.xuesong.factory;

import com.xuesong.service.AccountService;
import com.xuesong.service.imp.AccountServiceImp;

/**
 * @description: 模拟一个工厂类，该类可能存在于jar包中的，无法通过修改源码的方式提供默认构造函数
 * @author: Snow
 * @create: 2020-05-22 14:55
 **/
public class StaticFactory {

    public static AccountService getAccountService(){
        return new AccountServiceImp();
    }

}
