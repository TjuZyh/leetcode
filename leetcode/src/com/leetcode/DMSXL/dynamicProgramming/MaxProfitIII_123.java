package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/4 19:39
 * @Version 1.0
 */
/*
* 计算你所能获取的最大利润。你最多可以完成 两笔 交易
*   输入：prices = [3,3,5,0,0,3,1,4]
*   输出：6
* */
public class MaxProfitIII_123 {
    /*
    * 1. dp[i][0]: 不操作
    *    dp[i][1]: 第一次持有股票
    *    dp[i][2]: 第一次不持有股票
    *    dp[i][3]: 第二次持有股票
    *    dp[i][4]: 第二次不持有股票
    * 2. 第一次持有股票：
    *       dp[i][1] = Max(dp[i - 1][1], dp[i - 1][0] - prices[i])
    *   第一次不持有股票：
    *       dp[i][2] = Max(dp[i - 1][2], dp[i - 1][1] + prices[i])
    *   第二次持有股票：
    *       dp[i][3] = Max(dp[i - 1][3], dp[i - 1][2] - prices[i])
    *   第二次不持有股票：
    *       dp[i][4] = Max(dp[i - 1][4], dp[i - 1][3] + prices[i])
    * 3. dp[0][0] = 0; dp[0][1] = -prices[0]; dp[0][2] = 0; dp[0][3] = -prices[0]; dp[0][4] = 0
    * */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][5];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfitIII_123().maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
    }
}
