package com.xuesong.dao;

import com.xuesong.domain.Account;

import java.util.List;

/**
 * @description:
 * @author: Snow
 * @create: 2020-05-25 15:34
 **/
public interface AccountDao {
    /**
     * @Description: 查询所有账户信息
     * @Param: []
     * @Return: java.util.List<com.xuesong.domain.Account>
     * @Author: Snow
     * @Date: 2020/5/25
     **/
    List<Account> findAllAccount();

    /**
     * @Description: 根据ID查询账户信息
     * @Param: []
     * @Return: com.xuesong.domain.Account
     * @Author: Snow
     * @Date: 2020/5/25
     **/
    Account findAccountByID(Integer accountID);

    /**
     * @Description: 更新账户操作
     * @Param: [account]
     * @Return: void
     * @Author: Snow
     **/
    void saveAccount(Account account);

    /**
     * @Description: 删除账户操作
     * @Param: [account]
     * @Return: void
     * @Author: Snow
     **/
    void deleteAccount(Integer accountID);
}
