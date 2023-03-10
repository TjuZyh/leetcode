package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/10 23:36
 * @Version 1.0
 */
/*
* 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角，现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径
*   输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
*   输出：2
* */
public class UniquePathsWithObstacles_63 {
    //dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，无障碍物时
    //初始化：初始化第一行，遇到障碍物就停止赋值1
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }else {
                dp[i][0] = 1;
            }
        }
        for(int i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }else {
                dp[0][i] = 1;
            }
        }
        //如果当前位置是障碍，直接赋0即可
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = obstacleGrid[i][j] == 0 ? 0 : dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
