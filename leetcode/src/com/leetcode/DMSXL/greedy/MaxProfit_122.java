package com.leetcode.DMSXL.greedy;

/**
 * @Author zyh
 * @Date 2023/2/27 11:52
 * @Version 1.0
 */
/*
* 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格，返回 你能获得的 最大 利润
*   输入：prices = [7,1,5,3,6,4]
*   输出：7
* */
public class MaxProfit_122 {
    //将买卖股票的区间分解为一天一卖，这样做会发现区间内更大的利润可能
    //只需要收集正利润即可
    //[1,4,2,5] 利润[3,-1,3] 分别收集每一天的正利润即可
    public int maxProfit(int[] prices) {
        int ans = 0;
        for(int i = 1; i < prices.length; i++) {
            int profit = prices[i] - prices[i - 1];
            if(profit > 0) {
                ans += profit;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxProfit_122().maxProfit(new int[]{1, 4, 2, 5}));
    }
}
