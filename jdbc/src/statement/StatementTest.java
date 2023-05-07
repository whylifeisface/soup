package statement;

import org.testng.annotations.Test;

import java.util.Scanner;

public class StatementTest {
    @Test
    public void testLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String user = scanner.next();
        System.out.println("请输入密码");
        String password = scanner.next();
        String sql = "SELECT user,password FROM users where user =  '" + user + "'AND password = '" + password + "'";
        //User returnUser = get(sql,User.class);
        //if (returnUser!=null){
        //     System.out.println("登录成功");
        //}else {
        //    System.out.println("用户名不存在");
        // }
    }
    //public<t> int get(sql,Class<T> clazz)

}
