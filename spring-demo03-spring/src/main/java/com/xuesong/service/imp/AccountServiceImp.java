package com.xuesong.service.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.dao.imp.AccountDaoImp;
import com.xuesong.service.AccountService;

/**
 * 账户业务实现层
 * @author Snow
 * @date 2020/5/20-14:21
 */
public class AccountServiceImp implements AccountService {
    private AccountDao accountDao = new AccountDaoImp();
    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
