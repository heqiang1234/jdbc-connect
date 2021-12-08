package com.jdbc;

import com.jdbc.utils.JdbcUtils;

import java.sql.*;
import java.util.Date;

/**
 * @author HQ
 * @program: Jdbc
 * @description: PreparedStatement测试
 * @date 2021-12-07 22:20:16
 */
public class TestPrepareStatementInsert {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();

            //区别
            //使用？占位符代替参数
            String sql = "INSERT INTO `users` VALUES (?, ?, ?, ?, ?);";
            st = conn.prepareStatement(sql);//预编译SQL,先写sql，然后不执行

            //手动给参数赋值
            st.setInt(1,4);
            st.setString(2,"HQ12");
            st.setString(3,"123455");
            st.setString(4,"H123144@QQ.COM");
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
