package com.leetcode.DMSXL.greedy;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/6 11:36
 * @Version 1.0
 */
/*
* 给定一个区间的集合 intervals ，其中 intervals[i] = [start_i, end_i]
*   返回 需要移除区间的最小数量，使剩余区间互不重叠
* 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
* 输出: 1
* */
public class EraseOverlapIntervals_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });
        int minRight = intervals[0][1];
        int ans = 0;
        for(int i = 1; i < intervals.length; i++) {
            //如果有重复区间，则需要删除一个（累加一），然后留下区间最短的一个（取最小右界）
            if(intervals[i][0] < minRight) {
                ans++;
                minRight = Math.min(minRight, intervals[i][1]);
            }else {
                minRight = intervals[i][1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new EraseOverlapIntervals_435().eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }
}
