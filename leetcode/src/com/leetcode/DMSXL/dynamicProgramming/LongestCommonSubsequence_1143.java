package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/5/17 19:44
 * @Version 1.0
 */
/*
* 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度
*   输入：text1 = "abcde", text2 = "ace"
*   输出：3
* */
public class LongestCommonSubsequence_1143 {
    /*
     * 1. dp[i][j]表示当遍历到text1中的i - 1以及text2中的j - 1位置时，此时最长重复子数组的长度为dp[i][j]
     * 2. 存在两种情况：相同则直接 + 1，不相同则找之前的状态转移
     *      当 text1[i - 1] == text2[j - 1]时，dp[i][j] = dp[i - 1][j - 1] + 1
     *      当 text1[i - 1] != text2[j - 1]时，dp[i][j] = Max(dp[i - 1][j], dp[i][j - 1])
     * 3. 初始化：dp[i][0] = 0, dp[0][j] = 0
     * 4. 双层循环，从前到后
     * */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        int ans = 0;

        for(int i = 1; i <= text1.length(); i++) {
            for(int j = 1; j <= text2.length(); j++) {
                if(text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubsequence_1143().longestCommonSubsequence("abcde", "acedy"));
    }
}
