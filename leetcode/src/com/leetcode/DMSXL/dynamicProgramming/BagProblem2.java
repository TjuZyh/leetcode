package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/16 00:16
 * @Version 1.0
 */
/*
* 有n件物品和一个最多能背重量为 w 的背包。第i件物品的重量是 weight[i]，得到的价值是value[i] 。
*   每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大
* 输入：weight = [1, 3, 4] value = [15, 20, 30] w = 4
* 输出：35
* */
public class BagProblem2 {

    public int getMaxValue(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[] dp = new int[w + 1];
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = w; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        return dp[w];

    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int k = 4;
        System.out.println(new BagProblem2().getMaxValue(weight, value, k));
    }
}
