package com.xuesong.service.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.domain.Account;
import com.xuesong.service.AccountService;

import java.util.List;

/**
 * @description:账户的业务层实现类
 * @author: Snow
 * @create: 2020-05-25 17:16
 **/
public class AccountServiceImp implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountByID(Integer accountID) {
        return accountDao.findAccountByID(accountID);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountID) {
        accountDao.deleteAccount(accountID);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
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
