package com.leetcode.Graph;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/5/12 15:24
 * @Version 1.0
 */
/*
* Floyd算法解决单源点最短路径问题：
*   算法步骤：
*       1. 初始化距离矩阵
*       2. 依次判断两个节点中是否存在加入一个点使得距离变得更小，若存在则更新距离
* */
public class Floyd {
    public static Integer nodeCnt = 5;

    public int[][] floyd(int[][] graph) {
        int[][] distant = Arrays.copyOf(graph, graph.length);

        for(int k = 1; k <= nodeCnt; k++) {
            for(int i = 1; i <= nodeCnt; i++) {
                for(int j = 1; j <= nodeCnt; j++) {
                    distant[i][j] = Math.min(distant[i][j], distant[i][k] + distant[k][j]);
                    //System.out.println("distant[" + i + "][" + j + "] : " + distant[i][j]);
                }
            }
        }
        return distant;
    }

    public static void main(String[] args) {
        int[][] graph = new int[nodeCnt + 1][nodeCnt + 1];
        graph[1][3] = 4;
        graph[3][1] = 4;
        graph[4][3] = 2;
        graph[3][4] = 2;
        graph[1][2] = 3;
        //graph[2][1] = 3;
        //graph[5][4] = 2;
        graph[4][5] = 2;
        //graph[3][5] = 6;
        graph[5][3] = 6;

        for(int i = 1; i <= nodeCnt; i++) {
            for(int j = 1; j <= nodeCnt; j++) {
                if(graph[i][j] == 0) {
                    graph[i][j] = Integer.MAX_VALUE / 2;
                }
                if(i == j) {
                    graph[i][j] = 0;
                }
            }
        }

        Floyd floyd = new Floyd();
        int[][] floyd1 = floyd.floyd(graph);

        for(int i = 1; i <= nodeCnt; i++) {
            for(int j = 1; j <= nodeCnt; j++) {
                System.out.print(floyd1[i][j] + " ");
            }
            System.out.println();
        }
    }
}
