package connection;

import org.testng.annotations.Test;

import java.io.InputStream;
import java.io.ObjectStreamException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class ConnectionTest {

//    public <T> T SelectCommon(String sql,Class<T> clazz, Object ...args){
//
//    }


    @Test
    public void getConnection1() throws Exception {
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
//        System.out.println("是的 你好像成功了");
    }

}
