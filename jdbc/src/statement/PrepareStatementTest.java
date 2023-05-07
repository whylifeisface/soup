package statement;

import bean.Customer;
import com.mysql.cj.jdbc.JdbcPropertySet;
import connection.ConnectionTest;
//import jdk.internal.access.JavaIOFileDescriptorAccess;
import org.testng.annotations.Test;
import utils.JDBCutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.security.PublicKey;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.SimpleFormatter;

public class PrepareStatementTest {
    //耻辱下班


    @Test
    public void shiwuInsertTest() throws Exception {
        Connection conn = JDBCutil.getConnection();
        String sql = "insert into customers(name,email) value(?,?)";

        shiwuInsert(conn, sql, "name", "email");
    }

    public void shiwuInsert(Connection conn, String sql, Object... args) throws SQLException {
        conn.setAutoCommit(false);
        PreparedStatement ps = conn.prepareStatement(sql);
        //String sql = "insert into customers(name,email,) value(?,?,?)";

        for (int i = 0; i < args.length; i++) {
            ps.setObject(i + 1, args[i]);
        }
        ps.execute();


        conn.commit();
        JDBCutil.closeResource(null, ps, null);
    }


    @Test//暂时跳过
    public void SelectBlob() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCutil.getConnection();
            String sql = "select photos from customers where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setObject(1, 5);
            rs = ps.executeQuery();

            if (rs.next()) {
                Blob photos = rs.getBlob("photos");
                InputStream is = photos.getBinaryStream();
                FileOutputStream fos = new FileOutputStream("zhao.png");
                byte[] bytes = new byte[1024];
                int len;
                while ((len = is.read(bytes)) != -1) {
                    fos.write(bytes, 0, len);
                }
                is.close();
                fos.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeResource(conn, ps, rs);

        }

    }


    @Test
    //流怎么关
    public void insertBlob() throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        FileInputStream is = null;
        String sql = "insert into customers(name,email,birth,photos)VALUE (?,?,?,?)";
        try {
            conn = JDBCutil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "naotan");
            ps.setObject(2, "@qq.con");
            ps.setObject(3, "2021-01-01");
            File file = new File("C:\\Users\\Administrator\\Pictures\\bh3rd\\1.png");
            is = new FileInputStream(file);
            ps.setBlob(4, is);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            JDBCutil.closeResource(conn, ps, null);
        }


    }

    @Test//耻辱下播
    public void st() {
        String sql = "select name from customers where id < ?";
        //Customer cust = new Customer();
        List<Customer> select = get(Customer.class, sql, 4);
        select.forEach(System.out::println);
        //System.out.println(select);
    }

    public <T> List<T> get(Class<T> clazz, String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCutil.getConnection();
            ps = conn.prepareStatement(sql);
            //填充 ?
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            //
            int columnCount = rsmd.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            if (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();
                //new
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeResource(conn, ps, rs);
        }
        return null;
    }

    @Test
    public void TestGetSelect() {
        String sql = "select * from customers where id = ?";
        //Customer cust = new Customer();
        Customer select = getSelect(sql, Customer.class, 1);
        System.out.println(select);
    }

    public <T> T getSelect(String sql, Class<T> clazz, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCutil.getConnection();
            ps = conn.prepareStatement(sql);
            //填充 ?
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            //
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                T t = clazz.getDeclaredConstructor().newInstance();

                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeResource(conn, ps, rs);
        }
        return null;
    }


    @Test
    public void TESTSelect() {
        String sql = "select * from customers where id = ?";
        Customer select = Select(sql, "1");
        System.out.println(select);
    }

    public Customer Select(String sql, String... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JDBCutil.getConnection();
            ps = conn.prepareStatement(sql);
            //填充 ?
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            //
            int columnCount = rsmd.getColumnCount();

            if (rs.next()) {
                Customer cust = new Customer();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnName = rsmd.getColumnLabel(i + 1);
                    Field field = Customer.class.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(cust, columnValue);
                }
                return cust;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeResource(conn, ps, rs);
        }
        return null;
    }


    @Test

    public void selectTest() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet resultset = null;
        try {
            conn = JDBCutil.getConnection();
            String sql = "select * from customers where id = ?";

            ps = conn.prepareStatement(sql);

            ps.setObject(1, 1);
            resultset = ps.executeQuery();
            if (resultset.next()) {
                //获取值
                int id = resultset.getInt(1);
                String name = resultset.getString(2);
                String email = resultset.getString(3);
                Date birth = resultset.getDate(4);
                //Object[] data = new Object[]{id,name,email,birth};
                Customer customer = new Customer(id, name, email, birth);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeResource(conn, ps, resultset);
        }
    }


    @Test
    public void testCommonUpdate() {
        String sql = "update customers set name = ? where id = ?";
        update(sql, "aa", "1");

    }


    public void update(String sql, Object... args) {
        Connection conn = null;
        ResultSet rs = null;

        PreparedStatement ps = null;
        try {
            conn = JDBCutil.getConnection();
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeResource(conn, ps, rs);
        }
    }

    @Test//修改
    public void testUpdate() {
        //获取连接
        Connection conn = null;
        PreparedStatement ps = null;

        ResultSet rs = null;
        try {
            conn = JDBCutil.getConnection();
            //预编译sql 填充prepareStatement的实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            //填充占位符
            ps.setObject(1, "BB");
            ps.setObject(2, "18");
            //执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCutil.closeResource(conn, ps, rs);

        }
        //资源关闭
    }

    @Test//增加
    public void testinsert() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.Properties");

            Properties pros = new Properties();
            pros.load(is);

            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");

            //加载驱动
            Class.forName(driverClass);
            //获取连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println(conn);
            System.out.println("yohn you seem like win");
            //
            String sql = "INSERT INTO customers(name, email ,birth )Values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "哪吒");
            ps.setString(2, "nezha@mail.com");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse("1000-01-01");
            ps.setDate(3, new Date(date.getTime()));
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
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


        }
    }
}
