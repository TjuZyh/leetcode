package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/4/3 19:11
 * @Version 1.0
 */
/*
* 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警，计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额
*   输入：[1,2,3,1]
*   输出：4
* */
public class Rob_198 {
    /*
    * dp[i]: i位置可以偷取的最大金额数
    * 递推公式：dp[i] = Max(dp[i - 1], dp[i - 2] + nums[1])
    * 初始化：dp[0] = nums[0], dp[1] = Max(nums[0], nums[1])
    * 递归顺序：从2开始，从前到后遍历
    * */
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Rob_198().rob(new int[]{1, 2, 3, 1}));
    }
}
