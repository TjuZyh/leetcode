package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/20 18:10
 * @Version 1.0
 */
/*
* 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
*   请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0
* 输入：amount = 5, coins = [1, 2, 5]
* 输出：4
* */
public class Change_518 {
    /*
    * 完全背包类问题：将amount看做背包容量，硬币看做物品
    * 1. dp[j]: 容量为j的背包，存在几种装配方案
    * 2. 递推公式：dp[j] += dp[j - coins[i]]
    * 3. dp[0] = 1
    * 4. coins放在外循环正序遍历，amount在内循环正序遍历（可以重复）
    * */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        //由于是求组合个数，则需要先遍历物品，后遍历背包
        for(int i = 0; i < n; i++) {
            for(int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Change_518().change(5, new int[]{1, 2, 5}));
    }
}
