package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/20 18:23
 * @Version 1.0
 */
/*
* 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。
*   请你从 nums 中找出并返回总和为 target 的元素组合的个数
* 输入：nums = [1,2,3], target = 4
* 输出：7
* */
public class CombinationSum4_377 {
    //完全背包问题，但是得到的是排序
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        //由于是求排序个数，则需要先遍历背包，后遍历物品
        //如果求组合数就是外层for循环遍历物品，内层for遍历背包
        //如果求排列数就是外层for遍历背包，内层for循环遍历物品
        for(int j = 0; j <= target; j++) {
            for(int i = 0; i < n; i++) {
                if(j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum4_377().combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
