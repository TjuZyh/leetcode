package com.leetcode.DMSXL.hashTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/11/4 14:04
 * @Version 1.0
 */
/*
* 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
* 输出：2
* */
public class FourSumCount_454 {
    /*
    * 暴力
    * */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int cnt = 0;
        for(int i = 0; i < nums1.length; i++) {
            int first = nums1[i];
            for(int j = 0; j < nums2.length; j++) {
                int second = nums2[j];
                for(int m = 0; m < nums3.length; m++) {
                    int third = nums3[m];
                    for(int n = 0; n < nums4.length; n++) {
                        if(first + second + third + nums4[n] == 0) {
                            cnt++;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    /*
    * 分组 + 哈希表
    * 算法思路：既然4个数组具有很大的偶然性，那么可以通过两两分组，利用哈希表存储分组后的情况
    * */
    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> hashTable = getTwoNums(nums1, nums2);
        int cnt = 0;
        for(int i : nums3) {
            for (int j : nums4) {
                if(hashTable.containsKey(-(i + j))) {
                    cnt += hashTable.get(-(i + j));
                }
            }
        }
        return cnt;
    }

    public Map<Integer, Integer> getTwoNums(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            for(int j : nums2) {
                map.put(i + j, map.getOrDefault(i + j, 0) + 1);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-2, -1};
        int[] nums3 = new int[]{-1, 2};
        int[] nums4 = new int[]{0, 2};
        System.out.println(new FourSumCount_454().fourSumCount2(nums1, nums2, nums3, nums4));
    }
}
