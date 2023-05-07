package cn.ahtcm.deu;

import java.util.Scanner;

public class TestString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.next();
        Scanner scanner1 = new Scanner(System.in);

        String s2 = scanner1.nextLine();

        System.out.println("s1 " + s1);
        System.out.println("s2 " + s2);
        scanner.close();
        scanner1.close();
        StringBuilder stringBuilder = new StringBuilder(s2);
        stringBuilder.append(" game over");
        System.out.println(stringBuilder.toString());
    }
}
