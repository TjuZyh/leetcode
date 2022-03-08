package com.leetcode.java0308;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KWeakestRows2 {
    /*
    * 由于题中说明：军人总是排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。
    * 所以基于该特性可以使用二分进行查找最后出现1的位置，该位置+1即为军人的个数
    * */
    public int[] kWeakestRows(int[][] mat, int k){
        int m = mat.length , n = mat[0].length;
        ArrayList<int[]> power = new ArrayList<>();
        //利用二分的思想查找最后出现1的位置
        for(int i = 0 ; i < m ; i++){
            int start = 0 , end = n - 1 , pos = -1;
            while(start <= end){
                int mid = (start + end) / 2;
                if(mat[i][mid] != 1){
                    end = mid - 1;
                }else {
                    pos = mid;
                    start = mid + 1;
                }
            }
            power.add(new int[]{pos + 1 , i});
        }

        //lambda表达式用法
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((p1 , p2) ->{
            if(p1[0] != p2[0]){
                return p1[0] - p2[0];
            }else {
                return p1[1] - p2[1];
            }
        });
        for (int[] pair : power) {
            priorityQueue.offer(pair);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = priorityQueue.poll()[1];
        }
        return ans;
    }

}
