package com.example.nowcoderhuawei;

import java.util.Scanner;
import java.util.Stack;

public class MiddleTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        LDR(s);
    }

    public static void LDR(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        int count=0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '}':
                    break;
                case ',':
                    if(s.charAt(i-1)=='{'){
                        stack.push(' ');
                    }
                    result.append(stack.pop());
                    result.append(stack.pop());
                    break;
                default:
                    stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        System.out.println(result.toString());
    }
}
