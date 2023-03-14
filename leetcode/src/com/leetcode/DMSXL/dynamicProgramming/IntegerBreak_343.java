package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/14 22:14
 * @Version 1.0
 */
/*
* 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化
*   输入: n = 2
*   输出: 1
* */
public class IntegerBreak_343 {
    /*
    * 1. dp[i]：拆分数字i，得出的最大乘积为dp[i]
    * 2. dp[i] = max(dp[i], max(j * (i - j), j * dp[i - j])
    * 3. dp[2] = 1
    * 4. 从左到右
    * */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            for(int j = 1; j <= i / 2 + 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak_343().integerBreak(4));
    }
}
