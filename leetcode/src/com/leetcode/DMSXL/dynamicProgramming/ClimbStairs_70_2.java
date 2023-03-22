package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/22 09:56
 * @Version 1.0
 */
/*
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。每次你可以爬 1 或 2 个台阶, 你有多少种不同的方法可以爬到楼顶
 *   输入：n = 2
 *   输出：2
 * */
public class ClimbStairs_70_2 {
    /*
    * 除了找规律，也可以将该题视作完全背包类问题解决
    *   背包容量为n，物品重量为1，2(只能走1层或2层)
    * */
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        int[] weight = {1,2};
        dp[0] = 1;
        //n = 4 {1,1,2}与{2,1,1}是两种解，则该问题为排列问题
        //排列问题，外层正序背包，内层正序物品
        for(int j = 0; j <= n; j++) {
            for(int i = 0; i < weight.length; i++) {
                if(j >= weight[i]) {
                    dp[j] += dp[j - weight[i]];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbStairs_70_2().climbStairs(2));
    }
}
