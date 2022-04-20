package com.leetcode.baseAlgorithm.java0420;

/**
 * @Author zyh
 * @Date 2022/4/20 2:15 下午
 * @Version 1.0
 */
/*
* 198 : 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
*   影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
*   给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
* */
public class Rob {
    /*
    * 动态规划：
    *   转移方程的思考：对于第k间房
    *       1. 偷第k间，总金额为 k + 前k-2间房的最高总金额
    *       2. 不偷第k间，总金额为 前k-1间房的最高总金额
    *   转译方程：dp[i] = max(dp[i - 2] + nums[i] , dp[i - 1])
    *   初始化：dp[0] = nums[0]
    *          dp[1] = max(nums[0] , nums[1])
    * */
    public static int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        if(nums.length == 1){
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0] , nums[1]);
        for(int i = 2 ; i < nums.length ; i++){
            dp[i] = Math.max(dp[i - 2] + nums[i] , dp[i - 1]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));
    }
}
