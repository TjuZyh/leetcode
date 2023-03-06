package com.leetcode.DMSXL.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author zyh
 * @Date 2023/3/6 11:08
 * @Version 1.0
 */
/*
* 给定一些范围，范围之间均有交集则视为一个整体，求一共有几个整体
*   输入：points = [[10,16],[2,8],[1,6],[7,12]]
*   输出：2
* */
public class FindMinArrowShots_452 {
    //先排序，后根据交集范围不断缩小范围，计数
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (o1, o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int cnt = 1;
        int start = points[0][0], end = points[0][1];
        for(int i = 1; i < points.length; i++) {
            int curStart = points[i][0], curEnd = points[i][1];
            if(curStart >= start && curStart <= end) {
                start = Math.max(curStart, start);
                end = Math.min(end, curEnd);
            }else {
                cnt++;
                start = curStart;
                end = curEnd;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new FindMinArrowShots_452().findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
