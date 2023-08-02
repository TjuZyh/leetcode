package com.leetcode.DMSXL_2.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-02
 */
/*
* 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
*   1. 0 <= i, j, k, l < n
*   2. nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
* 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
* 输出：2
* */
public class FourSumCount_454 {
    //创建hash表 Map<sum, cnt> 存储前两个数组的两两元素之和，记录和出现的次数
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            for(int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        int ans = 0;
        for(int i : nums3) {
            for(int j : nums4) {
                ans = map.getOrDefault(-(i + j), 0);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FourSumCount_454().fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
