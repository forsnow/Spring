package com.xuesong.service.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.domain.Account;
import com.xuesong.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:账户的业务层实现类
 * @author: Snow
 * @create: 2020-05-25 17:16
 **/
@Service(value = "accountService")
public class AccountServiceImp implements AccountService {

    @Autowired
    private AccountDao accountDao;

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
}
