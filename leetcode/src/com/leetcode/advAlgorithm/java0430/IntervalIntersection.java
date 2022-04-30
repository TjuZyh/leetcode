package com.leetcode.advAlgorithm.java0430;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/4/30 3:58 下午
 * @Version 1.0
 */
/*
* 986 : 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi]
*   而secondList[j] = [startj, endj] 。
*   每个区间列表都是成对 不相交 的，并且 已经排序 。
*   返回这 两个区间列表的交集 。
*
* 输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
* 输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
* */
public class IntervalIntersection {
    //双指针分别指向两个数组
    //新的区间：左端点为两者最大左端点 ； 右端点为两者最小右端点
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length ,  m = secondList.length;
        int i = 0 , j = 0 ;
        List<int[]> res = new ArrayList<>();
        while(i < n && j < m){
            int low = Math.max(firstList[i][0] , secondList[j][0]);
            int high = Math.min(firstList[i][1] , secondList[j][1]);
            if(low <= high){
                res.add(new int[]{low , high});
            }
            //移动下一个区间
            //只需判断两个区间的右端点的大小，谁小谁移动到下一区间
            if(firstList[i][1] < secondList[j][1]){
                i++;
            }else{
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}
