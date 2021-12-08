package com.jdbc;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.*;

/**
 * @author HQ
 * @program: Jdbc
 * @description: jdbc测试
 * @date 2021-12-07 20:55:17
 */
public class JdbcFirstDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");
        //2. 用户信息和url
        String url = "jdbc:mysql://localhost:3306/jdbcstudy?useUnicode=true&&characterEncoding=utf8&&useSSL=true";
        String userName = "root";
        String passWord = "123456";
        //3. 连接成功，数据库对象
        Connection connection = DriverManager.getConnection(url, userName, passWord);

        //4. 执行sql的对象
        Statement statement = connection.createStatement();

        //5. 执行SQL的对象 去执行SQL
        String sql = "select * from users";

        ResultSet resultSet = statement.executeQuery(sql);

        //返回的结果集
        while (resultSet.next()) {
            System.out.println("id = "+ resultSet.getObject("id"));
            System.out.println("NAME = "+ resultSet.getObject("NAME"));
            System.out.println("PASSWORD = "+ resultSet.getObject("PASSWORD"));
            System.out.println("email = "+ resultSet.getObject("email"));
            System.out.println("birth = "+ resultSet.getObject("birthday"));
        }
        //6. 释放连接
        resultSet.close();
        connection.close();
        statement.close();

    }


}
