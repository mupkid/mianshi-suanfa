package com.example.nowcoderhuawei;

import java.util.Scanner;
import java.util.Stack;

public class StringReduce {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(doReduce(str));
    }

    public static int doReduce(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        if(!str.matches("[a-zA-Z]+")){
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if(stack.isEmpty()){
                stack.push(str.charAt(i));
                continue;
            }
            if(stack.peek()==str.charAt(i)){
                stack.pop();
            } else{
                stack.push(str.charAt(i));
            }
        }
        return stack.size();
    }
}
