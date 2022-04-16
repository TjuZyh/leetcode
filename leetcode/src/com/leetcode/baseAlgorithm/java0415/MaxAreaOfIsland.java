package com.leetcode.baseAlgorithm.java0415;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/4/15 8:19 下午
 * @Version 1.0
 */
/*
* 695: 给你一个大小为 m x n 的二进制矩阵 grid 。
*   岛屿 是由一些相邻的 1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
*   你可以假设grid 的四个边缘都被 0（代表水）包围着。
*   岛屿的面积是岛上值为 1 的单元格的数目。
* 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0
* */
public class MaxAreaOfIsland {
    /*
    * BFS
    * */
    int[] dx = {0 , 0 , -1 , 1};
    int[] dy = {-1 , 1 , 0 , 0};

    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int maxArea = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(areaOfGrid(grid , i , j) , maxArea);
                }
            }
        }
        return maxArea;
    }

    public int areaOfGrid(int[][] grid , int x , int y){
        Queue<int[]> queue = new LinkedList<>();
        int n = grid.length , m = grid[0].length , area = 1;
        int curGRidNum = grid[x][y];
        grid[x][y] = 0;
        queue.offer(new int[]{x , y});
        while (!queue.isEmpty()){
            int[] curGrid = queue.poll();
            int curX = curGrid[0] , curY = curGrid[1];
            for(int i = 0 ; i < 4 ; i++){
                int flagX = curX + dx[i] , flagY = curY + dy[i];
                if(flagX >= 0 && flagX < n && flagY >= 0 && flagY < m && grid[flagX][flagY] == curGRidNum){
                    grid[flagX][flagY] = 0;
                    queue.offer(new int[]{flagX , flagY});
                    area++;
                }
            }
        }
        return area;
    }

    /*
    * DFS
    * */
    public int maxAreaOfIsland1(int[][] grid) {
        int res = 0;
        for(int i = 0 ; i != grid.length ; ++i){
            for(int j = 0 ; j != grid[0].length ; ++j){
                res = Math.max(dfs(grid , i , j) , res);
            }
        }
        return res;
    }

    public int dfs(int[][] grid , int cur_i , int cur_j){
        if(cur_i < 0 || cur_j < 0 || cur_i == grid.length || cur_j == grid[0].length || grid[cur_i][cur_j] != 1){
            return 0;
        }
        grid[cur_i][cur_j] = 0;
        int[] dx = {0 , 0 , -1 , 1};
        int[] dy = {-1 , 1 , 0 , 0};
        int res = 1;
        for(int index = 0 ; index != 4 ; ++index){
            int next_i = cur_i + dx[index] , next_j = cur_j + dy[index];
            res += dfs(grid , next_i , next_j);
        }
        return res;
    }

}
