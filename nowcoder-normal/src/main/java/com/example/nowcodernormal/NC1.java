package com.example.nowcodernormal;

import java.math.BigInteger;
import java.util.Stack;

/**
 * 大数加法
 * 以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
 * （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
 */
public class NC1 {

    public String solve1 (String s, String t) {
        // 使用jdk自带的BigInteger
        BigInteger bigInteger1 = new BigInteger(s);
        BigInteger bigInteger2 = new BigInteger(t);
        return bigInteger1.add(bigInteger2).toString();
    }

    public String solve2 (String s, String t) {
        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0, i = s.length() - 1, j = t.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i < 0 ? 0 : s.charAt(i--) - '0';
            int y = j < 0 ? 0 : t.charAt(j--) - '0';
            int sum = x + y + carry;
            //插入到s字符串的第一个位置
            stringBuilder.insert(0, sum % 10);
            carry = sum / 10;
        }
        return stringBuilder.toString();
    }

    public String solve3(String s, String t){
        // 借助栈
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        int i = s.length() - 1, j = t.length() - 1, carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            carry += i >= 0 ? s.charAt(i--) - '0' : 0;
            carry += j >= 0 ? t.charAt(j--) - '0' : 0;
            stack.push(carry % 10);
            carry = carry / 10;
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }
}
