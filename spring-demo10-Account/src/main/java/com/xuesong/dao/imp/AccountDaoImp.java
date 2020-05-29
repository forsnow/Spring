package com.xuesong.dao.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.domain.Account;
import com.xuesong.utils.ConnetionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @description:账户的持久层操作
 * @author: Snow
 * @create: 2020-05-25 17:19
 **/
public class AccountDaoImp implements AccountDao {

    private QueryRunner runner;

    private ConnetionUtil connetionUtil;

    public void setConnetionUtil(ConnetionUtil connetionUtil) {
        this.connetionUtil = connetionUtil;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query(connetionUtil.getConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    @Override
    public Account findAccountByID(Integer accountID) {
        try {
            return runner.query(connetionUtil.getConnection(),"select * from account where id = ?",new BeanHandler<Account>(Account.class),accountID);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connetionUtil.getConnection(),"insert into account(name,money) values ( ?,?)",account.getName(),account.getMoney());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer accountID) {
        try {
            runner.update(connetionUtil.getConnection(),"delete from account where id = ?",accountID);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connetionUtil.getConnection(),"update account set name = ?,money = ? where id = ?",account.getName(),account.getMoney(),account.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Account findAccountByName(String accountName) {
        try {
           List<Account> accountList =  runner.query(connetionUtil.getConnection(),"select * from account where name = ?",new BeanListHandler<Account>(Account.class),accountName);
           if (accountList == null || accountList.size()==0){
                return null;
           }

           if (accountList.size()>1){
               throw new RuntimeException("数据重复有问题");
           }

           return accountList.get(0);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
