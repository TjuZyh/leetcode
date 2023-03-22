package com.leetcode.DMSXL.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/22 10:32
 * @Version 1.0
 */
/*
* 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量
* */
public class NumSquares_279 {
    //完全背包，n为容量，完全平方数为物品
    public int numSquares(int n) {
        int base = 1;
        List<Integer> weight = new ArrayList<>();
        int sum = base * base;
        while(sum <= n) {
            weight.add(sum);
            base++;
            sum = base * base;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0; i < weight.size(); i++) {
            for(int j = weight.get(i); j <= n; j++) {
                if(dp[j - weight.get(i)] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - weight.get(i)] + 1);
                }
            }
        }
        return dp[n];
    }

    //没必要将weight显式表示出来
    public int numSquares2(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i * i <= n; i++) {
            for(int j = i * i; j <= n; j++) {
                if(dp[j - i * i] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumSquares_279().numSquares(12));
    }
}
