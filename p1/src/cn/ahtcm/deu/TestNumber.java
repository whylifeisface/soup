package cn.ahtcm.deu;

import java.util.Scanner;

public class TestNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("value of a is " + a + " value of b is" + b);
        int sum = a + b;
        System.out.println(sum);
        scanner.close();
    }
}
