package com.leetcode.DMSXL.hashTable.arrayIntersection;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/11/2 21:48
 * @Version 1.0
 */
/*
* 给定两个数组 nums1 和 nums2 ，返回 它们的交集
*   输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
*   输出：[9,4]
* */
public class Intersection_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums1) {
            set.add(i);
        }
        Set<Integer> ans = new HashSet<>();
        for(int i : nums2) {
            if(set.contains(i)) ans.add(i);
        }
        /*int[] arr = new int[ans.size()];
        int index = 0;
        for(Integer i : ans){
            arr[index++] = i;
        }
        return arr;*/
        return ans.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        Arrays.stream(new Intersection_349().intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})).forEach(System.out::println);
    }
}
