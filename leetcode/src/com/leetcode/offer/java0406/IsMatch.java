package com.leetcode.offer.java0406;

/*
* offer19: 请实现一个函数用来匹配包含'. '和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（含0次）。
*   例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但与"aa.a"和"ab*a"均不匹配。
* */
public class IsMatch {
    /*
    *  状态定义： 设动态规划矩阵 dp ， dp[i][j] 代表字符串 s 的前 i 个字符和 p 的前 j 个字符能否匹配。
    *  转移方程： 需要注意，由于 dp[0][0] 代表的是空字符的状态， 因此 dp[i][j] 对应的添加字符是 s[i - 1] 和 p[j - 1]
    *       当 p[j - 1] = '*' 时， dp[i][j] 在当以下任一情况为 true 时等于 true ：
    *           dp[i][j - 2]： 即将字符组合 p[j - 2] * 看作出现 0 次时，能否匹配；
    *           dp[i - 1][j] 且 s[i - 1] = p[j - 2]: 即让字符 p[j - 2] 多出现 1 次时，能否匹配；
    *           dp[i - 1][j] 且 p[j - 2] = '.': 即让字符 '.' 多出现 1 次时，能否匹配；
    *       当 p[j - 1] != '*' 时， dp[i][j] 在当以下任一情况为 true 时等于 true ：
    *           dp[i - 1][j - 1] 且 s[i - 1] = p[j - 1]： 即让字符 p[j - 1] 多出现一次时，能否匹配；
    *           dp[i - 1][j - 1] 且 p[j - 1] = '.'： 即将字符 . 看作字符 s[i - 1] 时，能否匹配；
    * */
    public boolean isMatch(String s, String p) {
        int m = s.length() + 1 , n = p.length() + 1;
        boolean[][] dp = new boolean[m][n];
        //代表两个空字符串能够匹配
        dp[0][0] = true;
        //初始化首行
        // 首行 s 为空字符串，因此当 p 的偶数位为 * 时才能够匹配（即让 p 的奇数位出现 0 次，保持 p 是空字符串）。因此，循环遍历字符串 p ，步长为 2（即只看偶数位）。
        for(int j = 2 ; j < n ; j += 2){
            dp[0][j] = dp[0][j - 2] && p.charAt(j - 1) == '*';
        }
        //状态转移
        for(int i = 1 ; i < m ; i++){
            for(int j = 1 ; j < n ; j++){
                if(p.charAt(j - 1) == '*') {
                    if(dp[i][j - 2]) dp[i][j] = true;                                            // 1.
                    else if(dp[i - 1][j] && s.charAt(i - 1) == p.charAt(j - 2)) dp[i][j] = true; // 2.
                    else if(dp[i - 1][j] && p.charAt(j - 2) == '.') dp[i][j] = true;             // 3.
                } else {
                    if(dp[i - 1][j - 1] && s.charAt(i - 1) == p.charAt(j - 1)) dp[i][j] = true;  // 1.
                    else if(dp[i - 1][j - 1] && p.charAt(j - 1) == '.') dp[i][j] = true;         // 2.
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
