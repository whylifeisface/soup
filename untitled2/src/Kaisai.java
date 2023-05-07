import java.util.Scanner;

public class Kaisai {
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("welcome");
        System.out.println("encode 1 decode 2 exit 0");

        int key = 0;
        String s = "";
        while (true){
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 0: {
                    System.exit(0);

                }
                case 1: {
                    System.out.println("enter plain");
                    Scanner scanner1 = new Scanner(System.in);
                    s = scanner1.nextLine();
                    System.out.println("enter key");
                    Scanner scanner2 = new Scanner(System.in);
                    key = scanner2.nextInt();
                    encode(s,key);
                }
                case 2: {
                    decode(key,s);
                }
            }
        }
    }

    public static void encode(String s, int key) {

        String string="";
        for(int i=0;i<s.length();i++) {
            char c=s.charAt(i);
            if(c>='a'&&c<='z')//如果字符串中的某个字符是小写字母
            {
                c+=key%26;//移动key%26位
                if(c<'a')
                    c+=26;//向左超界
                if(c>'z')
                    c-=26;//向右超界
            }else if(c>='A'&&c<='Z')//如果字符串中的某个字符是大写字母
            {
                c+=key%26;//移动key%26位
                if(c<'A')
                    c+=26;//向左超界
                if(c>'Z')
                    c-=26;//向右超界
            }
            string +=c;//将解密后的字符连成字符串
        }
        System.out.println(s+"加密后为："+string);

    }

    public static void decode(int key, String code) {
        int k=Integer.parseInt("-"+key);
        String string="";
        for(int i=0;i<code.length();i++) {
            char c=code.charAt(i);
            if(c>='a'&&c<='z')//如果字符串中的某个字符是小写字母
            {
                c+=k%26;//移动key%26位
                if(c<'a')
                    c+=26;//向左超界
                if(c>'z')
                    c-=26;//向右超界
            }else if(c>='A'&&c<='Z')//如果字符串中的某个字符是大写字母
            {
                c+=k%26;//移动key%26位
                if(c<'A')
                    c+=26;//向左超界
                if(c>'Z')
                    c-=26;//向右超界
            }
            string +=c;//将解密后的字符连成字符串
        }
        System.out.println(code+"解密后为："+string);

    }

}
