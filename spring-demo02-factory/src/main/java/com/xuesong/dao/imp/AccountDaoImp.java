package com.xuesong.dao.imp;

import com.xuesong.dao.AccountDao;

/**
 * @author Snow
 * @Description：账户的持久层实现类
 * @date 2020/5/20-14:48
 */
public class AccountDaoImp implements AccountDao {
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
