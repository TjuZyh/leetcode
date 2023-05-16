package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/5/16 19:38
 * @Version 1.0
 */
/*
* 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度
*   输入：nums = [1,3,5,4,7]
*   输出：3
* */
public class FindLengthOfLCIS_674 {
    /*
    * 滑动窗口
    * */
    public int findLengthOfLCIS(int[] nums) {
        int left = 0, right = 1;
        int maxLen = 1;
        while(right < nums.length) {
            if(nums[right] > nums[right - 1]) {
                maxLen = Math.max(right - left + 1, maxLen);
            }else {
                left = right;
            }
            right++;
        }
        return maxLen;
    }

    /*
    * 1. dp[i]: i之前（包括i）同时以nums[i]为结尾的最长递增子序列的长度
    * 2. 递推公式：dp[i - 1] + 1 与 dp[i] 最大值，由于是连续子序列所以不需要考虑 0 到 (i - 1)的全部结果
    *       dp[i] = Max(dp[i], dp[j] + 1)
    * 3. 初始化：dp[i] = 1 (i = 0 ~ len)
    * 4. 从前向后
    * */
    public int findLengthOfLCIS2(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1]) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            if(dp[i] > ans) {
                ans = dp[i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new FindLengthOfLCIS_674().findLengthOfLCIS2(new int[]{1, 3, 5, 4, 7}));
    }

}
