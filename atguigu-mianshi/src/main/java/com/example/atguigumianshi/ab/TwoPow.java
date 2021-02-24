package com.example.atguigumianshi.ab;

import java.util.Scanner;

public class TwoPow {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i = 0;
        while(Math.pow(2,i)<num){
            ++i;
        }
        System.out.println(i);
    }
}
