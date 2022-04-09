package com.leetcode.offer.java0317;

/*
* 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
*   要求时间复杂度为O(n)
* */
public class MaxSubArray {
    /*
    * 动态规划：
    *   1.状态定义
    *       dp[i] : 代表以元素nums[i]为结尾的连续子数组最大和
    *   2.转移方程：
    *       dp[i] = dp[i - 1] + num[i] , dp[i - 1] > 0
    *               nums[i] , dp[i - 1] <= 0
    *   3.初始化：
    *       dp[0] = nums[0]
    *   4.输出：
    *       max(dp)
    * */
    public static int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for(int i = 1 ; i < dp.length ; i++){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            res = Math.max(dp[i] , res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));

    }
}
