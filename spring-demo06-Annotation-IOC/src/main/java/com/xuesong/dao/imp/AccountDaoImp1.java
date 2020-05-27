package com.xuesong.dao.imp;

import com.xuesong.dao.AccountDao;
import org.springframework.stereotype.Repository;

/**
 * @author Snow
 * @Description：账户的持久层实现类
 * @date 2020/5/20-14:48
 *
 *
 * <bean id="AccountDao" class="com.xuesong.dao.imp.AccountDaoImp"></bean>
 */
@Repository(value = "accountDao1")
public class AccountDaoImp1 implements AccountDao {

    public void saveAccount() {
        System.out.println("保存了账户1111");
    }
}
