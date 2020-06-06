package com.xuesong.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @description:连接工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
 * @author: Snow
 * @create: 2020-05-28 11:16
 **/
public class ConnetionUtil {

    private ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * @Description: 获取当前线程上的连接
     * @Param: []
     * @Return: java.sql.Connection
     * @Author: Snow
    **/
    public Connection getConnection(){
        try {
            //先从ThreadLocal上面获取
            Connection conn = threadLocal.get();
            //判断当前线程上面是否有连接
            if (conn == null){
                //从数据源中获取一个连接，并且存入ThreadLocal中
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            //返回当前线程上面的连接
            return conn;
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }

    /**
     * @Description: 把连接和线程解绑
     * @Param: []
     * @Return: void
     * @Author: Snow
    **/
    public void removeConnection(){
        threadLocal.remove();
    }
}
