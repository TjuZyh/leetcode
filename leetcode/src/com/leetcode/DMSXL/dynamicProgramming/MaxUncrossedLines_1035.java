package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/19 19:43
 * @Version 1.0
 */
/*
* 可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线， 返回可以绘制的最大连线数
*   输入：nums1 = [1,4,2], nums2 = [1,2,4]
*   输出：2
* */
public class MaxUncrossedLines_1035 {
    /*
    * 本题其实就是求两个序列的最长重复子序列长度
    * */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int ans = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        for(int i = 1; i <= nums1.length; i++) {
            for(int j = 1; j <= nums2.length; j++) {
                if(nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MaxUncrossedLines_1035().maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
    }
}
