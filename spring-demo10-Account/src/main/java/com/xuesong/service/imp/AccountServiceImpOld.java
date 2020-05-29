package com.xuesong.service.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.domain.Account;
import com.xuesong.service.AccountService;
import com.xuesong.utils.TransactionManager;

import java.util.List;

/**
 * @description:账户的业务层实现类
 * @author: Snow
 * @create: 2020-05-25 17:16
 **/
public class AccountServiceImpOld implements AccountService {

    private AccountDao accountDao;

    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> allAccount = accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return allAccount;
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }

    }

    @Override
    public Account findAccountByID(Integer accountID) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            Account account = accountDao.findAccountByID(accountID);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return account;
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountID) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(accountID);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }

    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            transactionManager.commit();
            //4.返回结果

        } catch (Exception e) {
            //回滚操作
            transactionManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放连接
            transactionManager.release();
        }

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            //得到转钱相关账户
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
            transactionManager.commit();
            //4.返回结果
        } catch (Exception e) {
            //回滚操作
            transactionManager.rollback();
            e.printStackTrace();
        }finally {
            //释放连接
            transactionManager.release();
        }

    }
}
