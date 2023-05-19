package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/19 19:57
 * @Version 1.0
 */
/*
* 你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和
*   输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
*   输出：6
* */
public class MaxSubArray_53 {
    /*
    * 不能用滑动数组做，因为滑动窗口内没有限制条件
    *   可以用贪心做
    * */
    public int maxSubArray2(int[] nums) {
        int maxCnt = Integer.MIN_VALUE;
        int curCnt = 0;
        for(int i = 0; i < nums.length; i++) {
            curCnt += nums[i];
            maxCnt = Math.max(maxCnt, curCnt);
            if(curCnt < 0) {
                curCnt = 0;
            }
        }
        return maxCnt;
    }

    /*
    * 1. dp[i]表示在i位置时最大连续子数组的和
    * 2. 存在两种：1）直接由dp[i - 1] + nums[i]转移； 2）以nums[i]开头重新计算
    *       dp[i] = Max(dp[i - 1] + nums[i], nums[i])
    * 3. dp[0] = nums[0]
    * 4. 从前到后
    * */
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = Integer.MIN_VALUE;

        for(int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            //最终结果不一定为dp[len - 1]，例如
            //nums[i]: -2, 1, -3, 4, -1, 2, 1, -5, 4
            //dp[i]:   -2, 1, -2, 4, 3, 5, 6, 1, 5
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxSubArray_53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
