package com.leetcode.offer.java0312;

import java.util.HashSet;

public class FindRepeatNumber {
    //hash方法
    public static int findRepeatNumber(int[] nums) {
        int[] hash = new int[nums.length];
        for(int i : nums){
            if(hash[i] == 0){
                hash[i]++;
            }else {
                return i;
            }
        }
        return 0;
    }

    //用set集
    public static int findRepeatNumber1(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : nums){
            int before = hashSet.size();
            hashSet.add(i);
            if(hashSet.size() == before){
                return i;
            }
        }
        return 0;
    }



    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber1(arr));
    }
}
