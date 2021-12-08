package com.jdbc;

import com.jdbc.utils.JdbcUtils;
import com.jdbc.utils.JdbcUtilsDbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 * @author HQ
 * @program: Jdbc
 * @description: DBCP实现
 * @date 2021-12-08 21:00:32
 */
public class TestDBCP {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtilsDbcp.getConnection();

            //区别
            //使用？占位符代替参数
            String sql = "INSERT INTO `users` VALUES (?, ?, ?, ?, ?);";
            st = conn.prepareStatement(sql);//预编译SQL,先写sql，然后不执行

            //手动给参数赋值
            st.setInt(1,34);
            st.setString(2,"HQ123");
            st.setString(3,"1234w55");
            st.setString(4,"H123w144@QQ.COM");
            //注意点：  sql.Date   数据库java.sql.Date()
            //          util.Date  Java    new Date().getTime()   获得时间戳
            st.setDate(5,new java.sql.Date(new Date().getTime()));

            int num = st.executeUpdate();
            if (num > 0) {
                System.out.println(num + "  插入成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
