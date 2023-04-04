package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/4/4 22:33
 * @Version 1.0
 */
/*
* 只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
*   输入：[7,1,5,3,6,4]
*   输出：5
* */
public class MaxProfit_121 {
    /*
    * 1. 设置二维数组：
    *   dp[i][0]: 第i天持有股票的最大现金
    *   dp[i][1]: 第i天不持有股票的最大现金
    * 2. 存在两种情况：
    *   持有股票：昨天就持有，则保持；昨天不持有，今天买入，则：
    *       dp[i][0] = Max(dp[i - 1][0], -price[i])
    *   不持有股票：昨天就不持有，则保持；昨天持有，今天卖出，则：
    *       dp[i][1] = Max(dp[i - 1][1], dp[i - 1][0] + price[i])
    * 3. dp[0][0] = -price[0] dp[0][1] = 0
    * 4. 遍历顺序：从前到后
    * */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit_121().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
