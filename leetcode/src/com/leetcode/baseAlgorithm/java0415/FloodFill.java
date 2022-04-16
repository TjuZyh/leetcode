package com.leetcode.baseAlgorithm.java0415;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/4/15 7:30 下午
 * @Version 1.0
 */
/*
* 733: 有一幅以 m x n 的二维整数数组表示的图画image，其中image[i][j]表示该图画的像素值大小。
* 你也被给予三个整数 sr , sc 和 newColor 。你应该从像素image[sr][sc]开始对图像进行 上色填充 。
*   为了完成 上色工作 ，从初始像素开始，记录初始坐标的 上下左右四个方向上 像素值与初始坐标相同的相连像素点，
*   接着再记录这四个方向上符合条件的像素点与他们对应 四个方向上 像素值与初始坐标相同的相连像素点，......
*   重复该过程。将所有有记录的像素点的颜色值改为newColor
*
* */
public class FloodFill {
    /*
    * BFS: 以此遍历当前四块四个方向上的四块，若与当前色块的颜色相同，就加入队列中，并更新其颜色
    * */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        //定义：上，下，左，右
        int[] dx = {0 , 0 , -1 , 1};
        int[] dy = {-1 , 1 , 0 , 0};

        int curColor = image[sr][sc];
        if(curColor == newColor){
            return image;
        }
        image[sr][sc] = newColor;
        int n = image.length , m = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr , sc});
        while (!queue.isEmpty()){
            int[] curPos = queue.poll();
            int curX = curPos[0] , curY = curPos[1];
            //按照四个方向进行BFS
            for(int i = 0 ; i < 4 ; i++){
                int x = curX + dx[i] , y = curY + dy[i];
                if(x >= 0 && x < n && y >= 0 && y < m && image[x][y] == curColor){
                    queue.offer(new int[]{x , y});
                    image[x][y] = newColor;
                }
            }
        }
        return image;
    }

    /*
    * DFS: 如果当前色块与初始色块颜色相同，则DFS其四个方向上的色块
    * */

    //定义：上，下，左，右
    int[] dx = {0 , 0 , -1 , 1};
    int[] dy = {-1 , 1 , 0 , 0};

    public int[][] floodFill1(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        if(curColor != newColor){
            dfs(image , sr , sc , curColor , newColor);
        }
        return image;
    }

    public void dfs(int[][] image , int x , int y , int curColor , int newColor){
        if(image[x][y] == curColor){
            image[x][y] = newColor;
            for(int i = 0 ; i < 4 ; i++){
                int curX = x + dx[i] , curY = y + dy[i];
                if(curX >= 0 && curX < image.length && curY >= 0 && curY < image[0].length){
                    dfs(image , curX , curY , curColor , newColor);
                }
            }

        }
    }
}
