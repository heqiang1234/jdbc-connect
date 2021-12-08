package com.jdbc;

import com.jdbc.utils.JdbcUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author HQ
 * @program: Jdbc
 * @description: 测试事务
 * @date 2021-12-08 19:50:42
 */
public class TestTransaction {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            //挂关闭数据库的自动提交，自动会开启事务
            conn.setAutoCommit(false);

            String sql1 = "UPDATE account SET money=money-100 where `name` = 'A' ";
            st = conn.prepareStatement(sql1);
            st.executeUpdate();

            String sql2 = "UPDATE account SET money=money+100 where `name` = 'B' ";
            st = conn.prepareStatement(sql2);
            st.executeUpdate();

            //业务完毕，提交事务
            conn.commit();
            System.out.println("成功");
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            JdbcUtils.release(conn,st,null);
        }
    }
}
