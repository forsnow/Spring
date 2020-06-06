package com.xuesong.dao;

import com.xuesong.domain.Account;
import jdk.nashorn.internal.objects.annotations.Property;
import org.springframework.stereotype.Repository;

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

    /**
     * @Description: 更新账户操作
     * @Param: [account]
     * @Return: void
     * @Author: Snow
    **/
    void updateAccount(Account account);

    /**
     * @Description: 根据名称查询账户
     * @Param: [accountName]
     * @Return: com.xuesong.domain.Account
     * 如果有唯一的一个结果就返回，如果没有结果就返回null，如果超过一个结果集就抛异常。
     * @Author: Snow
    **/
    Account findAccountByName(String accountName);
}
