package com.leetcode.DMSXL.greedy;

/**
 * @Author zyh
 * @Date 2023/2/27 11:20
 * @Version 1.0
 */
/*
* 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
*   输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
*   输出：6
* */
public class MaxSubArray_53 {
    //遍历数组，若发现当前的总和已经为负数，那么舍弃前面子数组，从当前重新计算
    public int maxSubArray(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE, count = 0;
        for(int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum, count);
            if(count <= 0) {
                //重新以下一个位置作为子数组的开始，因为当前已经为负，会拉低sum
                count = 0;
            }
        }
        return sum;
    }
}
