package com.leetcode.baseAlgorithm.java0417;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/4/17 1:22 下午
 * @Version 1.0
 */
/*
* 542:给定一个由 0 和 1 组成的矩阵 mat，
*   请输出一个大小相同的矩阵，其中每一个格子是 mat 中对应位置元素到最近的 0 的距离。
*   两个相邻元素间的距离为 1 。
* */
public class UpdateMatrix {
    /*
    * BFS：
    *   思路：既然要输出每一个点到0最近的距离，那么可以逆向考虑：
    *           从全部的0开始，依次BFS四个方向，每次在原有的距离上加一，直到遍历完全部矩阵
    *       类似于网络的泛洪，每次向四个方向泛洪一个距离
    * */
    //设定四个方向，上下左右
    int[] dx = {0 , 0 , -1 , 1};
    int[] dy = {-1 , 1 , 0 , 0};

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length , m = mat[0].length;
        int[][] dist = new int[n][m];
        //标记是否遍历过，防止多加一
        boolean[][] seen = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        //将所有的 0 添加进初始队列中，记录其坐标
        //并初始化遍历记录矩阵
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i , j});
                    seen[i][j] = true;
                }
            }
        }
        //bfs
        while(!queue.isEmpty()){
            int[] curPos = queue.poll();
            int x = curPos[0] , y = curPos[1];
            //每BFS一次都在源点的基础上加一
            for(int i = 0 ; i < 4 ; i++){
                int curX = x + dx[i] , curY = y + dy[i];
                //bfs四个方向
                if(curX >= 0 && curX < n && curY >= 0 && curY < m && !seen[curX][curY]){
                    dist[curX][curY] = dist[x][y] + 1;
                    queue.offer(new int[]{curX , curY});
                    seen[curX][curY] = true;
                }
            }
        }
        return dist;
    }
}
