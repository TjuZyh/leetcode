package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/10 21:34
 * @Version 1.0
 */
/*
* 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶
*   你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。请你计算并返回达到楼梯顶部的最低花费
* 输入：cost = [10,15,20]
* 输出：15
* */
public class MinCostClimbingStairs_746 {
    //dp[i]: 走到第i个台阶所用的最小花费
    //注意是要走到楼梯顶部，即n位置
    //后付钱版本
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }

    //先付钱版本
    public int minCostClimbingStairs2(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[n - 1],dp[n - 2]);
    }

    public static void main(String[] args) {
        System.out.println(new MinCostClimbingStairs_746().minCostClimbingStairs(new int[]{10, 15, 20}));
    }
}
