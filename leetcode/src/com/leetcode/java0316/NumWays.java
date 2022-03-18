package com.leetcode.java0316;

/*
*一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。答案需要取模 1e9+7（1000000007）
*   当为 1 级台阶： 剩 n-1 个台阶，此情况共有 f(n-1) 种跳法；
*   当为 2 级台阶： 剩 n-2 个台阶，此情况共有 f(n-2) 种跳法。
* */
public class NumWays {
    /*
    * 此类求多少种可能性的题目一般都有递推性质 ，即 f(n)和f(n−1)...f(1)之间是有联系的。
    * */
    public static int numWays(int n) {
        final int MOD = 1000000007;
        if(n < 2) return 1;
        int p = 0 , q = 1 , r = 1;
        for(int i = 2 ; i <= n ; i++){
            p = q;
            q = r;
            r = (p + q) >= MOD ? (p + q)  % MOD : (p + q);
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(numWays(7));
    }

}
