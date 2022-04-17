package com.leetcode.baseAlgorithm.java0417;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/4/17 3:28 下午
 * @Version 1.0
 */
/*
* 在给定的m x n网格grid中，每个单元格可以有以下三个值之一：
*   值0代表空单元格；
*   值1代表新鲜橘子；
*   值2代表腐烂的橘子。
* 每分钟，腐烂的橘子周围4 个方向上相邻 的新鲜橘子都会腐烂。
* 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回-1。
* */
public class OrangesRotting {
    //设定四个方向，上下左右
    static int[] dx = {0 , 0 , -1 , 1};
    static int[] dy = {-1 , 1 , 0 , 0};
    public static int orangesRotting(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        //对应没有1出现的情况
        boolean flag = false;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i , j});
                }
                if(grid[i][j] == 1){
                    flag = true;
                }
            }
        }
        if(!flag){
            return 0;
        }
        int minute = 0;
        while(!queue.isEmpty()){
            //visit对应泛洪确实更改了其他位置上的数，如果没有minute就不加一
            boolean visit = false;
            //当前在队中的2全部泛洪完毕后，算作一次，minute只加一次
            int size = queue.size();
            while(size-- > 0){
                int[] curPos = queue.poll();
                int x = curPos[0] , y = curPos[1];
                for(int i = 0 ; i < 4 ; i++){
                    int curX = x + dx[i] , curY = y + dy[i];
                    if(curX >= 0 && curX < n && curY >= 0 && curY < m && grid[curX][curY] == 1){
                        queue.add(new int[]{curX , curY});
                        grid[curX][curY] = 2;
                        visit = true;
                    }
                }
            }
            //确实传染到了，加一
            if(visit){
                minute++;
            }
        }
        //泛洪结束，如果还有1存在，直接返回-1
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return minute;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,2}};
        System.out.println(orangesRotting(grid));
    }
}
