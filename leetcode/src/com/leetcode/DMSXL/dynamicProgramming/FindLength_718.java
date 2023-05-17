package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/17 19:23
 * @Version 1.0
 */
/*
* 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度
*   输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
*   输出：3
 * */
public class FindLength_718 {
    /*
    * 1. dp[i][j]表示当遍历到A中的i - 1以及B中的j - 1位置时，此时最长重复子数组为dp[i][j]
    * 2. 当 nums1[i - 1] == nums2[j - 1]时，dp[i][j] = dp[i - 1][j - 1] + 1
    * 3. 初始化：dp[i][0] = 0, dp[0][j] = 0
    * 4. 双层循环，从前到后
    * */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;

        for(int i = 1; i <= nums1.length; i++) {
            for(int j = 1; j <= nums2.length; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new FindLength_718().findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
