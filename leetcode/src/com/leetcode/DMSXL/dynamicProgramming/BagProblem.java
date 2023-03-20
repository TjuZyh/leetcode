package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/16 00:16
 * @Version 1.0
 */
/*
*
* 01背包问题：
*   有n件物品和一个最多能背重量为 w 的背包。第i件物品的重量是 weight[i]，得到的价值是value[i] 。
*   每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大
* 输入：weight = [1, 3, 4] value = [15, 20, 30] w = 4
* 输出：35
* */
public class BagProblem {
    public int getMaxValue(int[] weight, int[] value, int w) {
        int n = weight.length;
        int m = w;
        int[][] dp = new int[n][m + 1];
        //初始化
        for(int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j <= m; j++) {
            if(j >= weight[0]) {
                dp[0][j] = value[0];
            }
        }
        System.out.println("init: ");
        System.out.println(Arrays.deepToString(dp));
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= m; j++) {
                if(weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println("dp: ");
        System.out.println(Arrays.deepToString(dp));
        return dp[n - 1][m];
    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int k = 4;
        System.out.println(new BagProblem().getMaxValue(weight, value, k));
    }
}
