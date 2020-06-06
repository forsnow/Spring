package com.xuesong.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * @description:与事务相关的工具类，包括开启事务，提交事务，回滚事务和释放连接
 * @author: Snow
 * @create: 2020-05-28 11:27
 **/
@Component("txManager")
@Aspect
public class TransactionManager {

    @Autowired
    private ConnetionUtil connetionUtil;

    @Pointcut("execution(* com.xuesong.service.imp.*.*(..))")
    private void pt1(){

    }

    /*开启事务*/
    public void beginTransaction(){
        try {
            connetionUtil.getConnection().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*提交事务*/
    public void commit(){
        try {
            connetionUtil.getConnection().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*回滚事务*/
    public void rollback(){
        try {
            connetionUtil.getConnection().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /*释放连接*/
    public void release(){
        try {
            connetionUtil.getConnection().close();//归还连接池中
            connetionUtil.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Around("pt1()")
    public Object aroundAdvice(ProceedingJoinPoint pjp){
        Object rtValue;

        try {
            //获取参数
            Object[] args = pjp.getArgs();
            //开启事务
            this.beginTransaction();
            //执行方法
            rtValue = pjp.proceed(args);
            //提交事务
            this.commit();
            //返回结果
            return rtValue;

        } catch (Throwable throwable) {
            this.rollback();
            throw new RuntimeException(throwable);
        } finally {
            this.release();
        }

    }

}
