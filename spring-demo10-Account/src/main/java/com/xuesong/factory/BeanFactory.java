package com.xuesong.factory;

import com.xuesong.service.AccountService;
import com.xuesong.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:用于创建Service代理对象的工厂
 * @author: Snow
 * @create: 2020-05-29 09:46
 **/
public class BeanFactory {
    private AccountService accountService;

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    private TransactionManager transactionManager;

    public  void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public AccountService getAccountService(){
        Object o = Proxy.newProxyInstance(accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object returnObject = null;
                        try {
                            //1.开启事务
                            transactionManager.beginTransaction();
                            //2.执行操作
                            returnObject = method.invoke(accountService, args);
                            //3.提交事务
                            transactionManager.commit();
                            //4.返回结果
                            return returnObject;
                        } catch (Exception e) {
                            //回滚操作
                            transactionManager.rollback();
                            throw new RuntimeException(e);
                        } finally {
                            //释放连接
                            transactionManager.release();
                        }
                    }
                });
        return (AccountService)o;
    }
}
