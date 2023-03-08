package com.leetcode.DMSXL.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/8 20:58
 * @Version 1.0
 */
/*
* 合并所有重叠的区间，并返回 一个不重叠的区间数组
*   输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
*   输出：[[1,6],[8,10],[15,18]]
* */
public class Merge_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }else {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        int start = intervals[0][0], end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= start && intervals[i][0] <= end) {
                end = Math.max(intervals[i][1], end);
            }else {
                ans.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        ans.add(new int[]{start, end});
        int[][] res = new int[ans.size()][];
        for(int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Merge_56().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
