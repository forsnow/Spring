package com.xuesong.service.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.factory.BeanFactory;
import com.xuesong.service.AccountService;

/**
 * 账户业务实现层
 * @author Snow
 * @date 2020/5/20-14:21
 */
public class AccountServiceImp implements AccountService {
    private AccountDao accountDao;
    @Override
    public void saveAccount() {
        accountDao = (AccountDao) BeanFactory.getBean("AccountDao");
        accountDao.saveAccount();
    }
}
