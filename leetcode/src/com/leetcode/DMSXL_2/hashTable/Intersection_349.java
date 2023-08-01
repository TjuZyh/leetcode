package com.leetcode.DMSXL_2.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.leetcode.DailyCheckIn._0918.LargestIsland_827;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-01
 */
/*
* 给定两个数组 nums1 和 nums2 ，返回 它们的交集
*   输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
*   输出：[9,4]
* */
public class Intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(nums1).forEach(set::add);
        Set<Integer> ans = new HashSet<>();
        for(int i : nums2) {
            if(set.contains(i)) {
                ans.add(i);
            }
        }
        //直接用stream流处理成int[]
        int[] res = ans.stream().mapToInt(x -> x).toArray();
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Intersection_349().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
