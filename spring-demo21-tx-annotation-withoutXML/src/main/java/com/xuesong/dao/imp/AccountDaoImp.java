package com.xuesong.dao.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author: Snow
 * @create: 2020-06-01 16:46
 **/
@Repository("AccountDao")
public class AccountDaoImp implements AccountDao {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public Account findAccountByID(Integer accountId) {
        List<Account> accountList = jdbcTemplate.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), accountId);
        return accountList.isEmpty() ? null : accountList.get(0);
    }

    @Override
    public Account findAccountByName(String accountName) {
        List<Account> accountList = jdbcTemplate.query("select * from account where name = ?", new BeanPropertyRowMapper<Account>(Account.class), accountName);
        if (accountList.isEmpty()) {
            return null;
        }

        if (accountList.size() > 1) {
            throw new RuntimeException("数据重复");
        }
        return accountList.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name = ? , money = ? where id = ?", account.getName(), account.getMoney(), account.getId());
    }
}
