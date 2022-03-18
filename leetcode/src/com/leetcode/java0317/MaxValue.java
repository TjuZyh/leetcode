package com.leetcode.java0317;

/*
* 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
*   你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
*   给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物
* */
public class MaxValue {
    /*
    * 动态规划：
    *   1.初始化
    *       dp[i][j]表示从棋盘的左上角开始，达到单元格[i , j]时能拿到礼物的累积最大值
    *   2.转移方程
    *       dp[i][j] = grid[i][j]   i == 0 && j ==0
    *                  dp[i - 1][j] + grid[i][j]   j == 0 && i != 0
    *                  dp[i][j - 1] + grid[i][j]   i == 0 && j != 0
    *                  max(dp[i - 1][j] , dp[i][j - 1]) + grid[i][j]    i != 0 && j != 0
    * */
    public static int maxValue(int[][] grid) {
        int m = grid.length , n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ; j++){
                if(i == 0 && j == 0) dp[i][j] = grid[i][j];
                else if(i == 0) dp[i][j] = dp[i][j - 1] + grid[i][j];
                else if(j == 0) dp[i][j] = dp[i - 1][j] + grid[i][j];
                else dp[i][j] = Math.max(dp[i][j - 1] , dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }


    public static void main(String[] args) {
        int[][] arr = {{1 , 3 , 1},
                       {1 , 5 , 1},
                       {4 , 2 , 1}};
        System.out.println(maxValue(arr));
    }


}
