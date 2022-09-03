package com.leetcode.DailyCheckIn._0903;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author zyh
 * @Date 2022/9/3 20:04
 * @Version 1.0
 */
public class FindLongestChain_646 {
    /*
    * 贪心：优先选择第二个数字小的，这样才可能链接更多的后续数对
    * 算法流程：
    *   1. 自定义排序，将第二位置小的优先排
    *   2. 设定last指针，指向上一个数对的第二个位置，满足当前数对的第一个位置大于last，则累加ans即可
    * */
    public int findLongestChain(int[][] pairs) {
        int last = Integer.MIN_VALUE , ans = 0;
        /*Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });*/
        Arrays.sort(pairs , (p1 , p2) -> p1[1] - p2[1]);
        for(int[] pair : pairs){
            if(last < pair[0]){
                last = pair[1];
                ans++;
            }
        }
        return ans;
    }
    /*
    * 动态规划：
    *   定义dp[i]为以pair[i]为结尾的最长数对链的长度
    * */
    public int findLongestChain1(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs , (p1 , p2) -> p1[0] - p2[0]);
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if(pairs[i][0] > pairs[j][1]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
