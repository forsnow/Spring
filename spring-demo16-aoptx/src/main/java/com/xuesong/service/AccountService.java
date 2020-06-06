package com.xuesong.service;

import com.xuesong.domain.Account;

import java.util.List;

/**
 * @description:账户的业务层接口
 * @author: Snow
 * @create: 2020-05-25 15:36
 **/
public interface AccountService {
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
     * @Description: 更新账户操作
     * @Param: [account]
     * @Return: void
     * @Author: Snow
    **/
    void updateAccount(Account account);

    /**
     * @Description: 删除账户操作
     * @Param: [account]
     * @Return: void
     * @Author: Snow
    **/
    void deleteAccount(Integer accountID);

    /**
     * @Description: 转账
     * @Param: [sourceName, targetName, money]
     * @Return: void
     * @Author: Snow
    **/
    void transfer(String sourceName,String targetName,Float money);


}
