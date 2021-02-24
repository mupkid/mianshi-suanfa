package com.example.nowcoderhuawei;

import java.util.Scanner;

public class StringSubSequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String S = scanner.nextLine();
        String L = scanner.nextLine();
        System.out.println(isEffective(S, L));
    }

    public static int isEffective(String s, String l) {
        int n = s.length(), m = l.length();
        int index = -1;
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == l.charAt(j)) {
                i++;
                index = j;
            }
            j++;
        }
        return index;
//        if (i != n) {
//            return -1;
//        } else {
//            return index;
//        }
    }
}
