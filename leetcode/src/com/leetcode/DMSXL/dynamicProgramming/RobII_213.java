package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/4/3 19:28
 * @Version 1.0
 */
/*
* 打家劫舍I的基础上，房屋是围成一圈的，求能够偷窃到的最高金额
*   输入：nums = [2,3,2]
*   输出：3
* */
public class RobII_213 {
    /*
    * 基于打家劫舍1.0，可以考虑两种情况：
    *   1. 不偷首位元素，这样就可以考虑尾部元素了，即寻找[1, n]的最大值
    *   2. 偷首位元素，这样就不可以考虑尾部元素了，即寻找[0, n - 1]的最大值
    * */

    public int rob(int[] nums) {
        return Math.max(robArea(nums, 0, nums.length - 1), robArea(nums, 1, nums.length));
    }

    public int robArea(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[start] = nums[start];
        dp[start + 1] = Math.max(nums[start], nums[start + 1]);
        for(int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[end - 1];
    }

    public static void main(String[] args) {
        System.out.println(new RobII_213().rob(new int[]{1, 2, 3, 1}));
    }
}
