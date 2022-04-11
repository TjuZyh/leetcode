package com.leetcode.baseAlgorithm.java0411;

import java.util.Arrays;

/*
* 283：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
* */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        //left: 指向当前已经处理好的序列的尾部
        //right: 找数字，指向待处理序列的头部
        int left = 0 , right = 0 , len = nums.length;
        while(right < len){
            if(nums[right] != 0){
                swap(nums , left , right);
                left++;
            }
            right++;
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /*
    * 直接覆盖
    * */
    public static void moveZeroes1(int[] nums) {
        int index = 0;
        for(int num : nums){
            if(num != 0){
                nums[index++] = num;
            }
        }
        for(int i = index ; i < nums.length ; i++){
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1 , 1 , 0 , 0};
        moveZeroes1(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
