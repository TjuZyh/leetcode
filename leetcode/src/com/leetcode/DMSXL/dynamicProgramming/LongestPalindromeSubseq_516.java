package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author JoyHan
 * @Date 2023/6/6 19:54
 * @Version 1.0
 */
/*
* 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度
*   输入：s = "bbbab"
*   输出：4
* */
public class LongestPalindromeSubseq_516 {
    /*
    * 1. dp[i][j]: 区间[i，j]中最长回文子序列的长度
    * 2. 递推公式：
    *       if(s[i] == s[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
    *       else 不相等，分别加入s[i]或s[j]，取最长
    *           dp[i][j] = Max(dp[i + 1][j], dp[i][j - 1])
    * 3. 当 i == j 时，dp[i][j] = 1，其余为0
    * 4. 递归顺序：从下到上，从左到右
    * */
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < s.length(); j++) {
                if(i == j) dp[i][j] = 1;
            }
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubseq_516().longestPalindromeSubseq("bbbab"));
    }


}
