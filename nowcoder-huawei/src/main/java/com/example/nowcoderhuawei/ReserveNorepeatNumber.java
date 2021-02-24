package com.example.nowcoderhuawei;

import java.util.Scanner;

/**
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 * 保证输入的整数最后一位不是0。
 *
 * 输入描述:
 *  输入一个int型整数
 * 输出描述:
 *  按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 *  输入
 *  9876673
 *  输出
 *  37689
 */
public class ReserveNorepeatNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] a = new int[10];
        int result=0;
        while(number>0){
            if(a[number%10]==0){
                a[number%10]++;
                result=result*10+number%10;
            }
            number/=10;
        }
        System.out.println(result);
    }


}
