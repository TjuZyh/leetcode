package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/6 11:49
 * @Version 1.0
 */
/*
* 可以无限次地完成交易，但是你每笔交易都需要付手续费
*   输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
*   输出：8
* */
public class MaxProfitVI_714 {
    /*
    * 可以复用买卖股票四，最多完成 len/2 笔交易，枚举不同交易数量时最大的利润情况
    *   时间超限
    * */
    public int maxProfit(int[] prices, int fee) {
        int k = prices.length / 2;
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i <= k; i++) {
            int profit = new MaxProfitIV_188().maxProfit(i, prices);
            ans = Math.max(ans, profit - fee * i);
        }
        return ans;
    }

    /*
    * 复用买卖股票二的思想，只是在递推公式中：卖出股票时需要扣除fee即可
    * */
    public int maxProfitVI(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] + fee);
        }
        return dp[prices.length - 1][1];


    }

    public static void main(String[] args) {
        System.out.println(new MaxProfitVI_714().maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }
}
