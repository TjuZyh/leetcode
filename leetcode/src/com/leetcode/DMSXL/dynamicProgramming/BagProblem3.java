package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/16 00:16
 * @Version 1.0
 */
/*
* 完全背包问题：
*   有n件物品和一个最多能背重量为 w 的背包。第i件物品的重量是 weight[i]，得到的价值是value[i] 。
*   每件物品可以使用无限次，求解将哪些物品装入背包里物品价值总和最大
* 输入：weight = [1, 3, 4] value = [15, 20, 30] w = 4
* 输出：35
* */
public class BagProblem3 {

    public int getMaxValue(int[] weight, int[] value, int w) {
        int n = weight.length;
        int[] dp = new int[w + 1];
        dp[0] = 0;
        for(int i = 0; i < n; i++) {
            //与01背包不同地方为遍历背包的顺序为正序
            for(int j = weight[i]; j <= w; j++) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[w];

    }

    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int k = 4;
        System.out.println(new BagProblem3().getMaxValue(weight, value, k));
    }
}
