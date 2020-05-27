package com.xuesong.dao.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:账户的持久层操作
 * @author: Snow
 * @create: 2020-05-25 17:19
 **/
@Repository(value = "accountDao")
public class AccountDaoImp implements AccountDao {

    @Autowired
    private QueryRunner runner;

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Account findAccountByID(Integer accountID) {
        try {
            return runner.query("select * from account where id = ?",new BeanHandler<Account>(Account.class),accountID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,money) values ( ?,?)",account.getName(),account.getMoney());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer accountID) {
        try {
            runner.update("delete from account where id = ?",accountID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
