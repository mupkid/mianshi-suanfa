package com.example.nowcoderhuawei;

import java.util.Scanner;

/**
 * 接受一个十六进制的数，输出该数值的十进制表示。
 */
public class HexToDec {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String s = scanner.next().substring(2);
            System.out.println(Long.parseLong(s, 16));
        }
    }
}
