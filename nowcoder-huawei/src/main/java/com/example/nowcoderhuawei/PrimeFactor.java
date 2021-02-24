package com.example.nowcoderhuawei;

import java.util.Scanner;

/**
 * 输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
 * 最后一个数后面也要有空格
 */
public class PrimeFactor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();

        for (int i = 2; i <= number / i; i++) {
            while (number % i == 0) {
                number /= i;
                System.out.print(i + " ");
            }
        }
        System.out.print(number<=1?"":number+" ");
    }
}
