package cn.ahtcm.deu;

import java.util.Scanner;

// Java数字、字符、字符串互相转换
// 计算并输出一个整数各位数字之和。如5423的各位数字之和为5+4+2+3=14.
public class Count {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        String s = String.valueOf(i);
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i1 = 0; i1 < chars.length; i1++) {
//             chars[i1];
            sum += Integer.parseInt(String.valueOf(chars[i1]));
        }

        System.out.println(sum);
    }
}
