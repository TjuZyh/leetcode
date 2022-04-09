package com.leetcode.offer.java0312;

public class MissingNumber {

    //sb做法
    public static int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length && i == nums[i]){
            i++;
        }
        return i;
    }

    //二分，可以基于索引以及当前索引的值作为查找条件，只有两种情况nums[i] 是否等于 i
    public static int missingNumber1(int[] nums){
        int left = 0 , right = nums.length - 1;
        while(left <= right){
            int middle = (left + right) / 2;
            if(middle == nums[middle]){
                left = middle + 1;
            }else{
                right = middle - 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {0};
        System.out.println(missingNumber(arr));
    }
}
