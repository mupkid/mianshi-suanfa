package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * <p>
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * <p>
 * 示例 3：
 * 输入：s = "a"
 * 输出："a"
 * <p>
 * 示例 4：
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母（大写和/或小写）组成
 * <p>
 * Related Topics 字符串 动态规划
 */
public class Leetcode5 {

    public static void main(String[] args) {
        // System.out.println(longestPalindrome3("babab"));
        System.out.println(longestPalindrome4("aacabdkacaa"));
    }

    /**
     * 暴力解法
     * 时间复杂度O(n^3)
     * 空间复杂度O(1)
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin = 0;
        // s.charAt(i)每次都会检查数组下标越界，因此先转换成字符数组，这一步非必须
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串 s[left..rignt] 是否为回文串
     */
    private static boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 中心扩散
     * 枚举所有可能的回文子串的中心位置
     * 中心位置可能是一个字符，也有可能是两个相邻的字符
     * 记录最长回文子串的相关变量
     * 时间复杂度O(n^2) 枚举中心位置的个数是2(n-1)，每一边向两边扩散检测是否是回文
     * 空间复杂度O(1)
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        char[] charArray = s.toCharArray();
        // 最后一个字符不用枚举，因为不可能向右边扩散
        for (int i = 0; i < len - 1; i++) {
            int oddLen = expandAroundCenter(charArray, i, i);
            int evenLen = expandAroundCenter(charArray, i, i + 1);

            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                // 回文串起点坐标需要记录
                begin = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * @param charArray 原始字符串的字符数组
     * @param left      起始左边界（可以取到）
     * @param right     起始右边界（可以取到）
     * @return 回文串的长度
     */
    private static int expandAroundCenter(char[] charArray, int left, int right) {
        // 当 left = right 的时候，回文中心是一个字符，回文串长度是奇数
        // 当 right = left + 1 的时候，回文中心两个字符，回文串长度是偶数
        int len = charArray.length;
        int i = left;
        int j = right;
        while (i >= 0 && j < len) {
            if (charArray[i] == charArray[j]) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 跳出while循环时，恰好满足 s.charAt(i) != s.charAt(j)
        // 回文串长度是 j-i+1-2 = j-i-1
        return j - i - 1;
    }

    /**
     * 动态规划
     * 回文串天然具有状态转移特性，因为回文串去掉两头仍然是回文串
     * 定义P(i,j)表示字符串s的第i到j个字母组成的串s[i..j]是否为回文串，写出状态转移方程
     * P(i,j) = P(i+1,j-1) && (s[i]==s[j]) (j-i >= 2)
     * 边界条件：子串长度为1或2
     * 得 P(i,i) = true, P(i, i+1) = (s[i] == s[i+1])
     * <p>
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(n^2)
     * 动态规划枚举的子串个数：O(n^2)
     * 中心扩散枚举的子串个数：O(2n)
     */
    public static String longestPalindrome3(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int begin = 0, subLen = 0;
        for (int k = 0; k < len; k++) {
            // dp[i][j]参考它左下方dp[i-1][j+1]的值
            // 应该先升序填列，后升序填行
            for (int i = 0; i + k < len; i++) {
                int j = i + k;
                if (k == 0) {
                    // k==0时，即i==j，子串长度为1，得到P(i,j)=true
                    dp[i][j] = true;
                } else if (k == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && k + 1 > subLen) {
                    // 如果s[i..j]是回文串，记录子串起点坐标和长度
                    begin = i;
                    subLen = k + 1;
                }
            }
        }
        return s.substring(begin, begin + subLen);
    }

    /**
     * 动态规划另一种写法
     */
    public static String longestPalindrome4(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] == charArray[j]) {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * Manacher算法
     * 专门用于查找最长回文子串的算法
     * <p>
     * 时间复杂度O(n)
     */
    public static String longestPalindrome5(String s) {
        int start = 0, end = -1;
        StringBuffer t = new StringBuffer("#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        t.append('#');
        s = t.toString();

        List<Integer> arm_len = new ArrayList<Integer>();
        int right = -1, j = -1;
        for (int i = 0; i < s.length(); ++i) {
            int cur_arm_len;
            if (right >= i) {
                int i_sym = j * 2 - i;
                int min_arm_len = Math.min(arm_len.get(i_sym), right - i);
                cur_arm_len = expand(s, i - min_arm_len, i + min_arm_len);
            } else {
                cur_arm_len = expand(s, i, i);
            }
            arm_len.add(cur_arm_len);
            if (i + cur_arm_len > right) {
                j = i;
                right = i + cur_arm_len;
            }
            if (cur_arm_len * 2 + 1 > end - start) {
                start = i - cur_arm_len;
                end = i + cur_arm_len;
            }
        }

        StringBuffer ans = new StringBuffer();
        for (int i = start; i <= end; ++i) {
            if (s.charAt(i) != '#') {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }

    public static int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        return (right - left - 2) / 2;
    }

}
