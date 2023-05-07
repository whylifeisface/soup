import java.util.Scanner;

public class CaesarCipher {
    public static String encrypt(String message, int key) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (Character.isLetter(c)) {
                c = (char) ((c - 'A' + key) % 26 + 'A');
            }
            ciphertext.append(c);
        }
        return ciphertext.toString();
    }

    // 解密函数
    public static String decrypt(String ciphertext, int key) {
        return encrypt(ciphertext, 26 - key);
    }

    public static void menu() {
        System.out.println("welcome");
        System.out.println("1 encode 2 decode 0 exit");

        String message = "";
        int key = 0;
        String encrypt = "";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            switch (i) {
                case 0: {
                    System.exit(0);
                    break;
                }
                case 1: {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("enter plain");
                    message = scanner1.nextLine();
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("enter key");
                    key = scanner2.nextInt();
                    encrypt = encrypt(message, key);
                    System.out.println(encrypt);
                    break;
                }
                case 2: {
                    String decrypt = decrypt(encrypt, key);
                    System.out.println(decrypt);
                    break;
                }
                default: {
                    System.out.println("default");
                }
            }
        }
    }

    // 测试函数
    public static void main(String[] args) {
        menu();
    }


}
