package com.leetcode.offer.java0406;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
* offer49：我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
* */
public class NthUglyNumber {
    /*
    * 堆 + set：
    *   每次取出堆顶元素 x，则 x 是堆中最小的丑数，由于 2x, 3x, 5x 也是丑数，因此将 2x, 3x, 5x 加入堆
    *   可能会出现丑数重复的问题，可以使用set去重
    * */
    public int nthUglyNumber(int n) {
        int[] factors = {2 , 3 , 5};
        Set<Long> seen = new HashSet<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        seen.add(1L);
        int uglyNum = 0;
        for(int i = 0 ; i < n ; i++){
            //堆顶为最小的丑数
            long cur = heap.poll();
            uglyNum = (int)cur;
            for(int factor : factors){
                long next = cur * factor;
                //set的add方法有返回值：如果当前添加的元素不存在与set中，则返回true
                //如果当前生成的是未生成过的丑数，则加到heap中
                if(seen.add(next)){
                    heap.offer(next);
                }
            }
        }
        return uglyNum;
    }

    /*
    * 动态规划：
    *   dp[] : dp[i]表示第i个丑数，第n个丑数即为dp[n]
    * */
    public int nthUglyNumber1(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int p2 = 1, p3 = 1, p5 = 1;
        for (int i = 2; i <= n; i++) {
            int num2 = dp[p2] * 2, num3 = dp[p3] * 3, num5 = dp[p5] * 5;
            dp[i] = Math.min(Math.min(num2, num3), num5);
            if (dp[i] == num2) {
                p2++;
            }
            if (dp[i] == num3) {
                p3++;
            }
            if (dp[i] == num5) {
                p5++;
            }
        }
        return dp[n];
    }
}
