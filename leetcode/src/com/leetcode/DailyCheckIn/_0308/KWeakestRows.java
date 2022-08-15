package com.leetcode.DailyCheckIn._0308;

import java.util.*;

public class KWeakestRows {
    /*
    * 解题思路：二维化一维，记录索引与个数，利用小顶堆进行存储并输出
    *   1. 遍历矩阵的每一行，用数组依次存下军人的个数
    *   2. 创建二维的记录数组存储原数组的索引以及个数
    *   3. 定义小顶堆，存储记录数组
    *   4. 根据k值，出堆前k位即可
    * */
    public static int[] kWeakestRows(int[][] mat, int k) {
        int sum = 0;
        //存储矩阵中每行军人的数量，将二维变为一维
        int[] rank = new int[mat.length];
        for(int i = 0 ; i < mat.length ; i++){
            sum = 0;
            for(int j = 0 ; j < mat[i].length ; j++){
                if(mat[i][j] == 1){
                    sum += 1;
                }
            }
            rank[i] = sum;
        }
        //存储格式[索引 , 个数]
        ArrayList<int[]> arrayList = new ArrayList<>();
        for(int i = 0 ; i < rank.length ; i++){
            arrayList.add(new int[]{i , rank[i]});
        }

        //利用优先队列创建小顶堆
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else{
                    return o1[1] - o2[1];
                }
            }
        });

        //依次入堆
        for(int[] arr : arrayList){
            priorityQueue.offer(arr);
        }

        int[] result = new int[k];
        for(int i = 0 ; i < k ; i++){
            result[i] = priorityQueue.poll()[0];
        }
        return result;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}};
        int[] result = kWeakestRows(arr , 4);
        for(int i : result){
            System.out.print(i + " ");
        }
    }


}
