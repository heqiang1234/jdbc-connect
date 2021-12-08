package com.jdbc;

import com.jdbc.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author HQ
 * @program: Jdbc
 * @description: 测试插入数据
 * @date 2021-12-07 22:05:20
 */
public class TestInsert {

    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            st = conn.createStatement();

            String sql = "INSERT INTO `users` VALUES (6, 'HQ', '123456', 'HQ@HUNDSUN.com', '1997-01-01');";
            int num = st.executeUpdate(sql);
            if(num > 0 )
            {
                System.out.println(num + "  插入成功");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
