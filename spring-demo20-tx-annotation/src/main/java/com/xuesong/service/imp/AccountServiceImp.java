package com.xuesong.service.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.domain.Account;
import com.xuesong.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:账户的业务层实现类
 * @author: Snow
 * @create: 2020-05-25 17:16
 **/
@Service("AccountService")
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountByID(Integer accountID) {
        return accountDao.findAccountByID(accountID);
    }

    @Override
    public Account findAccountByName(String accountName) {
        return accountDao.findAccountByName(accountName);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void transfer(String sourceName, String targetName, Float money) {
        System.out.println("transfer begin");
        Account sourceAccount = accountDao.findAccountByName(sourceName);
        Account targetAccount = accountDao.findAccountByName(targetName);

        //账户增删账户金额
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        targetAccount.setMoney(targetAccount.getMoney()+money);

        //更新账户信息
        accountDao.updateAccount(sourceAccount);
        //int i = 1/0;
        accountDao.updateAccount(targetAccount);
        //3.提交事务

    }
}
