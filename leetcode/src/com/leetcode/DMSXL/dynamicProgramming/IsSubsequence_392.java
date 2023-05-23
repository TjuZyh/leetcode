package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/5/23 19:37
 * @Version 1.0
 */
/*
* 给定字符串 s 和 t ，判断 s 是否为 t 的子序列
*   输入：s = "abc", t = "ahbgdc"
*   输出：true
* */
public class IsSubsequence_392 {
    /*
    * 双指针 front back
    * */
    public boolean isSubsequence2(String s, String t) {
        int front = 0, back = 0;
        if(s.length() == 0) {
            return true;
        }
        if(t.length() == 0) {
            return false;
        }
        while(back < t.length()) {
            if(s.charAt(front) == t.charAt(back)) {
                front++;
            }
            back++;
            if(front == s.length()) {
                return true;
            }
        }
        return false;
    }

    /*
    * 1. dp[i][j]：下标为i-1的s和下标为j-1的t，相同子序列的长度dp[i][j]
    * 2. 递归公式：
    *       if(s[i - 1] == t[j - 1]) dp[i][j] = dp[i - 1][j - 1]
    *       if(s[i - 1] != t[j - 1]) dp[i][j] = dp[i][j - 1]
    * 3. 初始化：
    *       dp[0][0] = 0， dp[i][0] = 0
    * */
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= t.length(); j++) {
                if(s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        if(dp[s.length()][t.length()] == s.length()) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence_392().isSubsequence("abc", "ahbgdc"));
    }
}
