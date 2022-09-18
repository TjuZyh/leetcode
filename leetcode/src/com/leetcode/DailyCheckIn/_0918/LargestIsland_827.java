package com.leetcode.DailyCheckIn._0918;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/9/18 18:12
 * @Version 1.0
 */
public class LargestIsland_827 {
    /*
    * 复杂度O(n^3)，时间超限...
    * */
    public int largestIsland(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int max = getMaxArea(grid);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    grid[i][j] = 1;
                    int newArea = getMaxArea(grid);
                    max = Math.max(max , newArea);
                    grid[i][j] = 0;
                }
            }
        }
        return max;
    }

    private int[] dx = {0 , 0 , -1 , 1};
    private int[] dy = {1 , -1 , 0 , 0};
    public int getMaxArea(int[][] grid){
        //n行m列
        int n = grid.length , m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        boolean flag = false;
        int[] newAreaIndex = findUnVisited(visited, grid);
        int max = 0;
        while (newAreaIndex[0] != -1){
            queue.add(new int[]{newAreaIndex[0] , newAreaIndex[1]});
            int cnt = 1;
            while(!queue.isEmpty()){
                int[] cur = queue.poll();
                int curX = cur[0] , curY = cur[1];
                visited[curX][curY] = 1;
                for(int i = 0 ; i < 4 ; i++){
                    int nextX = curX + dx[i] , nextY = curY + dy[i];
                    if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && visited[nextX][nextY] == 0 && grid[nextX][nextY] == 1){
                        queue.add(new int[]{nextX , nextY});
                        visited[nextX][nextY] = 1;
                        cnt++;
                    }

                }
            }
            max = Math.max(cnt , max);
            newAreaIndex = findUnVisited(visited , grid);
        }
        return max;
    }

    public int[] findUnVisited(int[][] visited , int[][] grid){
        int n = visited.length, m = visited[0].length;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    return new int[]{i , j};
                }
            }
        }
        return new int[]{-1 , -1};
    }

    public static void main(String[] args) {
        int[][] grid = {{1,1,0},{0,0,1},{1,1,1}};
        int[][] visited = {{0,0,0},{0,0,0},{0,0,0}};
        //System.out.println(Arrays.toString(new LargestIsland_827().findUnVisited(visited, grid)));
        System.out.println(new LargestIsland_827().getMaxArea(grid));
        System.out.println(new LargestIsland_827().largestIsland(grid));
    }
}
