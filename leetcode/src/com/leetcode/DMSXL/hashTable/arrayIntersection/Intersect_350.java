package com.leetcode.DMSXL.hashTable.arrayIntersection;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/11/2 22:08
 * @Version 1.0
 */
public class Intersect_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums1) {
            set.add(i);
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i : nums2) {
            if(set.contains(i)) {
                map.put(i, map.get(i) - 1);
                if(map.get(i) >= 0) {
                    ans.add(i);
                }
            }
        }
        return ans.stream().mapToInt(x -> x).toArray();
    }

    public static void main(String[] args) {
        Arrays.stream(new Intersect_350().intersect(new int[]{4, 9, 9, 5}, new int[]{9, 4, 9, 8, 4})).forEach(System.out::println);
    }
}
