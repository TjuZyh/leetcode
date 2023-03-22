package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/22 10:07
 * @Version 1.0
 */
/*
* 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额
*   计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1
*   每种硬币的数量是无限的
* 输入：coins = [1, 2, 5], amount = 11
* 输出：3
* */
public class CoinChange_322 {
    /*
    * 完全背包类问题
    * 1. dp[j]: 背包容量为j时，需要的最少硬币数
    * 2. dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1)
    * 3. 所有位置均用max赋初值，dp[0] = 0
    * 4. 可以重复使用，且是组合，则先正序遍历物品，后正序遍历背包
    * */
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 0; i < n; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                //剪枝：dp[j - coins[i]]不为max时才有选择的必要
                if(dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange_322().coinChange(new int[]{1, 2, 5}, 11));
    }
}
