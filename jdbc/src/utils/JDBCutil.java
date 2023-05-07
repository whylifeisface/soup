package utils;

import connection.ConnectionTest;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCutil {
    public static Connection DruidConnection() {
        d
    }
//        public static Connection getConnectionCommit() throws IOException {
//            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//            Properties pros= new Properties();
//            pros.load(is);
//            pros.getProperty("url");
//            pros.getProperty("driverClass");
//            pros.get
//        }


    public static Connection getConnection() throws Exception {
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.Properties");

        Properties pros = new Properties();
        pros.load(is);

        String user = pros.getProperty("user");
        String password = pros.getProperty("password");
        String url = pros.getProperty("url");
        String driverClass = pros.getProperty("driverClass");


        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, password);
        System.out.println(conn);
        System.out.println("yohn you seem like win");
        return conn;

    }

    public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
