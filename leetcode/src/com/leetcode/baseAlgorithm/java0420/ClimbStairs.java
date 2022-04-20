package com.leetcode.baseAlgorithm.java0420;

/**
 * @Author zyh
 * @Date 2022/4/20 1:58 下午
 * @Version 1.0
 */
/*
* 70 : 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
*   每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
* */
public class ClimbStairs {
    /*
    * 动态规划：
    *   用f(x)代表爬到第x级台阶的方案数，即f(x) = f(x - 1) + f(x - 2)
    *   理解：第 n 级台阶 = 第 n - 1 级台阶爬一级 + 第 n - 2 级台阶爬两级
    * */
    public static int climbStairs(int n) {
        //表示第i级台阶的方案数
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(2));
    }
}
