package com.leetcode.baseAlgorithm.java0420;

import java.util.List;

/**
 * @Author zyh
 * @Date 2022/4/20 2:41 下午
 * @Version 1.0
 */
/*
* 120 : 给定一个三角形 triangle ，找出自顶向下的最小路径和。
*   每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
*   也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
* */
public class MinimumTotal {
    /*
    * 动态规划：
    *   转译方程：f[i][j] = min(f[i−1][j−1] , f[i−1][j]) + c[i][j]
    * */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        //dp[][]: 记录着走到该位置需要用的路径长度
        int[][] dp = new int[n][n];
        //初始化
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1 ; i < n ; i++){
            //该位置（最左侧）只能从其上方走下来，直接赋值即可
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
            //转译方程，填充dp
            for(int j = 1 ; j < i ; j++){
                dp[i][j] = Math.min(dp[i - 1][j - 1] , dp[i - 1][j]) + triangle.get(i).get(j);
            }
            //该位置（最右侧）只能从其左上方走下来，直接赋值即可
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = dp[n - 1][0];
        for(int i = 1 ; i < n ; i++){
            minTotal = Math.min(minTotal , dp[n - 1][i]);
        }
        return minTotal;
    }
}
