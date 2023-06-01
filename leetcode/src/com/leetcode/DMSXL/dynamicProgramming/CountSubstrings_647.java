package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author JoyHan
 * @Date 2023/6/1 17:56
 * @Version 1.0
 */
/*
* 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目
*   输入：s = "abc"
*   输出：3
* */
public class CountSubstrings_647 {
    /*
    * 1. dp[i][j]：代表区间[i, j]的子串是否为回文子串
    * 2. 递推公式：
    *   if(s[i] != s[j]) dp[i][j] = false
    *   else：存在三种情况
    *       1. i == j, dp[i][j] = true, 'a'
    *       2. |i - j| = 1, dp[i][j] = true, 'aa'
    *       3. else, dp[i][j] = dp[i + 1][j - 1]
    * 3. dp[i][j] = false
    * 4. 递推公式：dp[i][j] = dp[i + 1][j - 1]
    *       由于i 依赖于后面的 i + 1，所以对于i要从下往上
    *       对于j，从前到后，同时区间[i, j]，所以j的取值要大于等于i
    * */
    public int countSubstrings(String s) {
        int ans = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(i == j || Math.abs(i - j) == 1) {
                        dp[i][j] = true;
                        ans++;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if(dp[i][j]) {
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new CountSubstrings_647().countSubstrings("aaa"));
    }


}
