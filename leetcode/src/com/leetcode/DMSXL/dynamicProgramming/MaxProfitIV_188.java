package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/5 20:45
 * @Version 1.0
 */
/*
* 计算你所能获取的最大利润。你最多可以完成 k 笔交易
*   输入：k = 2, prices = [2,4,1]
*   输出：2
* */
public class MaxProfitIV_188 {
    /*
    * 在III的基础上，设定 2K + 1 个状态，0表示不操作，单数表示买入，双数表示卖出
    * */
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[prices.length][2 * k + 1];
        //初始化：买入就初始化为-prices[0]
        for(int i = 1; i < 2 * k; i += 2) {
            dp[0][i] = -prices[0];
        }
        for(int i = 1; i < prices.length; i++) {
            for(int j = 0; j < 2 * k - 1; j += 2) {
                dp[i][j + 1] = Math.max(dp[i - 1][j + 1], dp[i - 1][j] - prices[i]);
                dp[i][j + 2] = Math.max(dp[i - 1][j + 2], dp[i - 1][j + 1] + prices[i]);
            }
        }
        return dp[prices.length - 1][k * 2];
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfitIV_188().maxProfit(2, new int[]{2, 4, 1}));
    }
}
