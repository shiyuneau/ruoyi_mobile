package com.ruoyi.common.accessdb;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.*;

/**
 * 连接 access 数据库的工具类
 * @author shiyu
 * @Description
 * @create 2019-02-26 9:53
 */
@Component
public class AccessConnectionUtils {
    private static final String dbURL = "jdbc:ucanaccess://" +
            "D:\\工作相关\\wbxm\\JW\\JW.mdb";

    public static void main(String[] args) throws Exception {
        Connection connection = getConn();
        System.out.println(connection.getCatalog());
    }

    @Bean(value = "accessConn")
    public Connection accessConnection() {
        return getConn();
    }

    /*
     * 加载驱动
     */
    static {
        try {
            // Step 1: Loading or registering Oracle JDBC driver class
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {
            System.out.println("Problem in loading or registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
    }

    //建立连接
    public static Connection getConn() {
        try {
            // Step 2: Opening database connection
            // Step 2.A: Create and get connection using DriverManager class
            return DriverManager.getConnection(dbURL,"","admin123456");
        } catch (Exception e) {
            System.out.println("AccessDB connection fail");
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
        try {
            if (rs != null) {
                // 这里出现异常了，rs关闭了吗？，如果没有怎么解决,ps , con也是一样的。
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (con != null)
                    try {
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}