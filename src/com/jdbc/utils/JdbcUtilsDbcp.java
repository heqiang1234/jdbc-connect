package com.jdbc.utils;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author HQ
 * @program: Jdbc
 * @description: DBCP测试
 * @date 2021-12-08 20:45:08
 */
public class JdbcUtilsDbcp {

    private static DataSource dataSource = null;

    static {

        try {
            InputStream in = JdbcUtilsDbcp.class.getClassLoader().getResourceAsStream("dbconfig.properties");
            Properties properties = new Properties();
            properties.load(in);

            //创建数据源  工厂模式 --》 创建
            dataSource = BasicDataSourceFactory.createDataSource(properties);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();//从数据源
    }

    //释放连接资源
    public static void release(Connection conn, Statement st, ResultSet rs) {

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(st != null){
            try {
                st.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
