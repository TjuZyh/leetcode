package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/10 22:02
 * @Version 1.0
 */
/*
* 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
*   机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角
*   总共有多少条不同的路径
* 输入：m = 3, n = 7
* 输出：28
* */
public class UniquePaths_62 {
    //dp[i][j]: 到(i, j)位置存在dp[i][j]种路径
    //dp[i][j] = dp[i][j - 1] + dp[i - 1][j]，当前位置的路径数是由其上方以及左方之和
    //初始化：第一行以及第一列均为1，因为只存在一种路径，即直走
    //遍历顺序：观察递推公式，发现需要上层以及前面的状态，则按层遍历即可
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths_62().uniquePaths(3, 7));
    }
}
