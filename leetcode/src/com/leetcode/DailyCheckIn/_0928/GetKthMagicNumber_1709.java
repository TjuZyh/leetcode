package com.leetcode.DailyCheckIn._0928;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/9/28 18:20
 * @Version 1.0
 */
/*
* 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数
* 1, 3, 5, 7, 9, 15, 21, 25, 27, 35...
* */
public class GetKthMagicNumber_1709 {
    /*
    * 最小堆 + set
    *   依次取最小堆顶元素，乘因子后加入堆中（利用set集控制元素重复），以此规则构建最小堆
    *   取k次堆顶元素即可
    * */
    public int getKthMagicNumber(int k) {
        int[] factors = {3, 5, 7};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        set.add(1L);
        heap.add(1L);
        int ans = 0;
        for(int i = 0 ; i < k ; i++){
            long cur = heap.poll();
            ans = (int)cur;
            for(int factor : factors){
                long next = cur * factor;
                if(set.add(next)){
                    heap.add(next);
                }
            }
        }
        return ans;
    }
    /*
    * 动态规划：三指针
    *   dp[i]：代表第i个数，dp[1] = 1
    *   dp[i] = min(dp[p3] * 3 , dp[p5] * 5 , dp[p7] * 7)
    *   如果dp[i]与dp[p3] * 3 , dp[p5] * 5 , dp[p7] * 7相等，则对应指针 + 1
    * */
    public int getKthMagicNumber2(int k) {
        int[] dp = new int[k + 1];
        dp[1] = 1;
        int p3 = 1 , p5 = 1 , p7 = 1;
        for(int i = 2 ; i <= k ; i++){
            int num3 = dp[p3] * 3 , num5 = dp[p5] * 5 , num7 = dp[p7] * 7;
            dp[i] = Math.min(Math.min(num3 , num5) , num7);
            if(dp[i] == num3){
                p3++;
            }
            if(dp[i] == num5){
                p5++;
            }
            if(dp[i] == num7){
                p7++;
            }
        }
        return dp[k];
    }

    public static void main(String[] args) {
        System.out.println(new GetKthMagicNumber_1709().getKthMagicNumber(5));
    }
}
