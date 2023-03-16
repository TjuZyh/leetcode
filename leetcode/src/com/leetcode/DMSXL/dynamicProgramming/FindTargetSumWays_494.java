package com.leetcode.DMSXL.dynamicProgramming;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/17 00:18
 * @Version 1.0
 */
/*
* 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式，
*   返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
*
* */
public class FindTargetSumWays_494 {
    /*
    * 首先可以选择+的区间以及-的区间，+的区间元素总和为(target + sum) / 2
    *   将元素总和比作背包容量，将本题转换为01背包问题，问容量确定的背包 装满背包的情况下，有几种装配方案
    * 1. dp[j]: 容量为j的背包，存在几种装配方案
    * 2. 递推公式：dp[j] += dp[j - num[i]]
    * 3. dp[0] = 1
    * 4. nums放在外循环，target在内循环，且内循环倒序
    * */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i : nums) {
            sum += i;
        }
        if((target + sum) % 2 != 0) return 0;
        if(target > sum || target < 0) return 0;
        int left = (target + sum) / 2;
        int[] dp = new int[left + 1];
        dp[0] = 1;
        for(int i = 0; i < nums.length; i++) {
            for(int j = left; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[left];
    }

    int cnt = 0;
    public int findTargetSumWays2(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return cnt;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if(index == nums.length) {
            if(sum == target) {
                cnt++;
            }
        }else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindTargetSumWays_494().findTargetSumWays(new int[]{2, 2, 1}, 5));
    }
}
