package com.xuesong.dao;

import com.xuesong.domain.Account;

/**
 * @description:账户的持久层接口
 * @author: Snow
 * @create: 2020-06-01 15:57
 **/
public interface AccountDao {
    /*根据id查询账户*/
    Account findAccountByID(Integer accountId);
    /*根据姓名查询账户*/
    Account findAccountByName(String accountName);
    /*更新账户*/
    void updateAccount(Account account);
}
