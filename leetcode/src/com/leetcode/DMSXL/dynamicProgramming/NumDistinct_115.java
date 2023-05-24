package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/24 19:13
 * @Version 1.0
 */
/*
* 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数
*   输入：s = "babgbag", t = "bag"
*   输出：5
* */
public class NumDistinct_115 {
    /*
    * 1. dp[i][j]：表示以i - 1结尾的s串中出现以j - 1结尾的t串的个数
    * 2. 递推公式：
    *   if(s[i - 1] == t[j - 1]) 存在两种情况：
    *       dp[i][j] = dp[i - 1][j - 1]
    *       dp[i][j] = dp[i - 1][j] 可能存在当前位置与前一个位置字符相同的情况，需要不考虑当前s[i - 1]位置
    *           举个例子：s = bagg, t = bag
    *   else：不相等，则不考虑当前s[i - 1]位置
    *       dp[i][j] = dp[i - 1][j]
    * 3. 初始化：
    *       dp[i][0] = 1，代表s的任意位置与空串的t做匹配，一定可以匹配上，记为1
    *       dp[0][j] = 0，代表空串s与t绝对匹配不上，记为0
    *       dp[0][0] = 1，代表空串和空串是可以匹配上的
    * 4. 从前到后，从上到下
    * */
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for(int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }

    public static void main(String[] args) {
        System.out.println(new NumDistinct_115().numDistinct("bagg", "bag"));
    }
}
