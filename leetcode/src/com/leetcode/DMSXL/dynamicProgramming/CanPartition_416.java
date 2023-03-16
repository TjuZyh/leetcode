package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/16 22:55
 * @Version 1.0
 */
/*
* 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
*   输入：nums = [1,5,11,5]
*   输出：true
* */
public class CanPartition_416 {
    /*
    * 本题可以套01背包问题实现，背包的容量为sum/2，物品为数组中的元素，价值以及重量均为num[i]
    *   最终判断是够背包正好背满（dp[target] == target）即可
    * 1. dp[j]: 背包容量为j的时候，可以放下物品的最大值
    * 2. dp[j] = Max(dp[j], dp[j - num[i]] + num[i])
    * 3. dp[0] = 0
    * 4. 遍历顺序：先正序物品，后反序背包
    * */
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if(sum % 2 != 0) return false;
        int[] dp = new int[sum / 2 + 1];
        for(int i = 0; i < n; i++) {
            for(int j = sum / 2; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[sum / 2] == sum / 2;
    }

    public static void main(String[] args) {
        System.out.println(new CanPartition_416().canPartition(new int[]{1, 5, 11, 5}));
    }
}
