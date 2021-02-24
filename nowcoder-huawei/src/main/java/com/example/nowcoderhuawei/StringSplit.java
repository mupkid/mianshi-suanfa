package com.example.nowcoderhuawei;

import java.util.Scanner;

/**
 * 连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 * 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 */
public class StringSplit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            int zerofill = 8-s.length()%8;
            StringBuilder stringBuilder = new StringBuilder(s);
            while(zerofill>0 && zerofill<8){
                stringBuilder.append("0");
                zerofill--;
            }
            String str1 = stringBuilder.toString();
            while(str1.length()>0){
                System.out.println(str1.substring(0,8));
                str1 = str1.substring(8);
            }
        }
    }
}
