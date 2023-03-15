package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/15 23:06
 * @Version 1.0
 */
/*
* 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种
*   输入：n = 3
*   输出：5
* */
public class NumTrees_96 {
    /*
    * 1. dp[i]: 1 - i个节点构成的BST个数
    * 2. dp[i] += dp[j - 1] * dp[i - j]
    *   左子树与右子树的乘积即为当前以j为根节点的BST的个数，根节点可以从1开始一直到i
    * 3. dp[0] = 1
    * 4. 从左到右
    * */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new NumTrees_96().numTrees(3));
    }
}
