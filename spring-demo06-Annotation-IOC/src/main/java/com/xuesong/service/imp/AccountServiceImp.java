package com.xuesong.service.imp;

import com.xuesong.dao.AccountDao;
import com.xuesong.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 账户业务实现层
 * @author Snow
 * @date 2020/5/20-14:21
 *
 *
 *  <bean id="AccountService" class="com.xuesong.service.imp.AccountServiceImp"></bean>
 */

@Service(value = "accountService")
@Scope(value = "prototype")
public class AccountServiceImp implements AccountService {
    @Resource(name = "accountDao2")
    private AccountDao accountDao2;
    @Override
    public void saveAccount() {
        accountDao2.saveAccount();
    }
}
