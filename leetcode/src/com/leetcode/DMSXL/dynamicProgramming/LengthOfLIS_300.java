package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/5/16 19:19
 * @Version 1.0
 */
/*
* 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度
*   输入：nums = [10,9,2,5,3,7,101,18]
*   输出：4 ([2,3,7,101])
* */
public class LengthOfLIS_300 {
    /*
    * 1. dp[i]: i之前（包括i）同时以nums[i]为结尾的最长递增子序列的长度
    * 2. 递推公式：i位置之前的 dp[j] + 1 与当前的最大值
    *       即，if(nums[j] < nums[i]) dp[i] = Max(dp[i], dp[j] + 1)
    * 3. 初始化：dp[i] = 1 (i = 0 ~ len)
    * 4. 从前向后
    * */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    //这里要取最大值，因为dp[j]最大不一定正好在i - 1位置
                    //例如：0 1 0 3 2 i = 3时，在 j = 1时 dp[i] = dp[j] + 1 为3，
                    //  而j = 2时，此时dp[i] = dp[j] + 1 为2，所需需要取最大值
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if(dp[i] > ans) {
                ans = dp[i];
            }
            System.out.println(Arrays.toString(dp));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLIS_300().lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
