package com.example.atguigumianshi.aa;

public class StringPool58Demo {
    public static void main(String[] args) {
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        // 结果为true
        System.out.println(str1.intern() == str1);

        System.out.println();

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        // 结果为false
        System.out.println(str2.intern() == str2);
    }
}
