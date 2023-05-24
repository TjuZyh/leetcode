package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/24 19:54
 * @Version 1.0
 */
/*
* 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数
*   输入: word1 = "sea", word2 = "eat"
*   输出: 2
* */
public class MinDistance_583 {
    /*
    * 其实就是求两个字符串中的最长公共重复子序列的长度，然后分别用两个串的长度减该长度剩余的就是需要切的步数
    * */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        int maxLen = 0;

        for(int i = 1; i <= word1.length(); i++) {
            for(int j = 1; j <= word2.length(); j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return word1.length() + word2.length() - 2 * maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new MinDistance_583().minDistance("leetcode", "etco"));
    }
}
