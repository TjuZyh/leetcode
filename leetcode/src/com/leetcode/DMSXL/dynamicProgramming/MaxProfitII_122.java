package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/4 19:15
 * @Version 1.0
 */
/*
* 在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。返回 你能获得的 最大 利润
*   输入：prices = [7,1,5,3,6,4]
*   输出：7
* */
public class MaxProfitII_122 {
    /*
    * 1. dp[i][0]：表示持有股票时的最大利润
    *    dp[i][1]：表示不持有股票时的最大利润
    * 2. 持有股票：前一天就持有则保持现状 或 前一天不持有，当前天买入
    *    (与I不同的是前一天不持有的情况，由于I中只能交易一次，那么前一天不持有则约一定为0，则为 -prices[i])
    *       dp[i][0] = Max(dp[i - 1][0], dp[i - 1][1] - prices[i])
    *    不持有股票：前一天不持有则保持现状 或 前一天持有，当前天卖出
    *       dp[i][1] = Max(dp[i - 1][1], dp[i - 1][0] + prices[i])
    * 3. 初始化：dp[0][0] = -prices[0] dp[0][1] = 0
    * 4. 遍历顺序：从前到后
    * */
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfitII_122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
