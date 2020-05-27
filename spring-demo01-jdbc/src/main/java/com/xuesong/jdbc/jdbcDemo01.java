package com.xuesong.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 程序的耦合
 * @author Snow
 * @date 2020/5/20-9:34
 */
public class jdbcDemo01 {
    public static void main(String[] args) throws Exception{
        //1.注册驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        //2.获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/spring?useUnicode=true&characterEncoding=utf8","root","123456");
        //3.获取预处理 sql 语句对象
        PreparedStatement preparedStatement = connection.prepareStatement("select * from account");
        //4.获取结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        //5.遍历结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }
        //释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }
}
