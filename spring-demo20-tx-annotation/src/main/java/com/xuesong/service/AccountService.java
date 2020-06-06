package com.xuesong.service;

import com.xuesong.domain.Account;

/**
 * @description:账户业务层接口
 * @author: Snow
 * @create: 2020-06-03 14:08
 **/
public interface AccountService {

    Account findAccountByID(Integer accountId);

    Account findAccountByName(String accountName);

    void transfer(String sourceName ,String targetName ,Float money);

}
