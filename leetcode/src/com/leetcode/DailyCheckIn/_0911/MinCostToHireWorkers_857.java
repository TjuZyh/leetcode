package com.leetcode.DailyCheckIn._0911;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author zyh
 * @Date 2022/9/11 15:22
 * @Version 1.0
 */
public class MinCostToHireWorkers_857 {
    public double minCostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for(int i = 0 ; i < n ; i++){
            h[i] = i;
        }
        //将wage[i]/quality[i]大的排在前面，贪心思想
        Arrays.sort(h , (a , b) ->{
            return quality[b] * wage[a] - quality[a] * wage[b];
        });
        double res = 1e9;
        double totalq = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a , b) -> b - a);
        for(int i = 0 ; i < k - 1 ; i++){
            totalq += quality[h[i]];
            pq.offer(quality[h[i]]);
        }
        for(int i = k - 1 ; i < n ; i++){
            int idx = h[i];
            totalq += quality[idx];
            pq.offer(quality[idx]);
            double totalc = ((double) wage[idx] / quality[idx]) * totalq;
            res = Math.min(res , totalc);
            totalq -= pq.poll();
        }
        return res;
    }
}
