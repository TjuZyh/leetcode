package com.leetcode.java0316;

public class Fib {
    //如果直接利用递归会导致超时
    //大量重复的递归计算，例如f(n)和f(n−1)两者向下递归需要各自计算f(n−2)的值。
    public static int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return (fib(n - 1) + fib(n - 2)) % 1000000007 ;
    }

    //记忆化递归方法：在递归的基础上，新建一个长度为n的数组，用于在递归时存储f(0)-f(n)的数字值，重复遇到可以直接从数组中取
    //缺点需要使用o(N)的额外空间
    public static int fib1(int n){
        if(n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
            if(dp[i] >= 1000000007) {
                dp[i] %= 1000000007;
            }
        }
        return dp[n];
    }

    //动态规划
    //由于 F(n)只和 F(n-1)与 F(n-2)有关，因此可以使用「滚动数组思想」把空间复杂度优化成O(1)
    //其实和用dp数组存储的思想一样，但是数组总会用到当前索引前两个位置上的值，所以可以直接声明3个变量存储当前需要值即可
    public static int fib2(int n){
        final int MOD = 1000000007;
        if(n < 2) return n;
        int p = 0 , q = 0 , r = 1;
        for(int i = 2 ; i <= n ; i++){
            p = q;
            q = r;
            r = (p + q) % MOD;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(fib2(2));
    }
}
