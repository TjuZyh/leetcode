package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/10 21:08
 * @Version 1.0
 */
/*
* 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶, 你有多少种不同的方法可以爬到楼顶
*   输入：n = 2
*   输出：2
* */
public class ClimbStairs_70 {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs_70().climbStairs(1));
    }
}
