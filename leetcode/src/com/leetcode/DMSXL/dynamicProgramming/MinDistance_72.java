package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/30 20:02
 * @Version 1.0
 */
/*
* 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数
*   可以插入、删除、替换
* 输入：word1 = "horse", word2 = "ros"
* 输出：3
* */
public class MinDistance_72 {
    /*
    * 1. dp[i][j] 代表下标为 i - 1 的word1和下标为 j - 1的word2相同需要的最小操作数
    * 2. 递归公式：分为四种情况
    *   if(word1[i - 1] == word2[j - 1])
    *       不操作，即dp[i][j] = dp[i - 1][j - 1]
    *   else
    *       1. 删除word2的一个词：dp[i][j] = dp[i][j - 1] + 1
    *       2. 为word2增加一个词：dp[i][j] = dp[i - 1][j] + 1
    *           等效于删除word1的一个词
    *       3. 替换word2的一个词：dp[i][j] = dp[i - 1][j - 1] + 1
    *           替换即全部相同，再+1操作数
    * 3. 初始化
    *   dp[i][0] = i; word1想要变为空串的操作数为i
    *   dp[0][j] = j;
    * 4. 递归顺序：上到下、左到右
    * */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for(int i = 0; i <= word1.length(); i++) dp[i][0] = i;
        for(int j = 0; j <= word2.length(); j++) dp[0][j] = j;

        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1));
                }
            }
        }

        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance_72().minDistance("horse", "ros"));
    }
}
