package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/6 11:19
 * @Version 1.0
 */
/*
* 算法计算出最大利润，卖出股票后，你无法在第二天买入股票
*   输入: prices = [1,2,3,0,2]
*   输出: 3
* */
public class MaxProfitV_309 {
    /*
    * 1. 设定四种状态：
    *   dp[i][0]：买入股票状态（保持之前买入状态 or 当前买入，前一天是冷冻期 or 当前买入，保持之前卖出状态）
    *   dp[i][1]：保持卖出股票状态（保持之前卖出状态 or 前一天是冷冻期）
    *   dp[i][2]：今天卖出股票状态（昨天一定持有股票，所以由前一天买入状态转移得来）
    *   dp[i][3]：冷冻期（今天卖出股票状态转移得来）
    * 2. 转移方程：
    *   dp[i][0] = Max(dp[i - 1][0], dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i])
    *   dp[i][1] = Max(dp[i - 1][1], dp[i - 1][3])
    *   dp[i][2] = dp[i - 1][0] + prices[i]
    *   dp[i][3] = dp[i - 1][2]
    * 3. 初始化
    *   dp[0][0] = -prices[0] 其余为0
    * */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfitV_309().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
