package com.xuesong.utils;

import java.sql.SQLException;

/**
 * @description:与事务相关的工具类，包括开启事务，提交事务，回滚事务和释放连接
 * @author: Snow
 * @create: 2020-05-28 11:27
 **/
public class TransactionManager {

    private ConnetionUtil connetionUtil;

    public void setConnetionUtil(ConnetionUtil connetionUtil) {
        this.connetionUtil = connetionUtil;
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

}
