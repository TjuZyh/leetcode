package com.leetcode.offer.java0321;

/*
* 输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可
*   数组为顺序排列，要充分利用这一特性，二分或者双指针
* */
public class TwoSum {
    /*
    * 双指针思想：
    *   1. 初始化：双指针i，j分别指向数组nums的左右两端
    *   2. 循环搜索：因为数组是一次递增的
    * */
    public int[] twoSum(int[] nums, int target) {
        int i = 0 , j = nums.length - 1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum < target) i++;
            else if(sum > target) j--;
            else return new int[] {nums[i] , nums[j]};
        }
        return new int[0];
    }
}
