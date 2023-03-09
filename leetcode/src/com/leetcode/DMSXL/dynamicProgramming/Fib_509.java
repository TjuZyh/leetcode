package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/9 20:24
 * @Version 1.0
 */
/*
* 斐波那契数
*   F(0) = 0，F(1) = 1
*   F(n) = F(n - 1) + F(n - 2)，其中 n > 1
* 输入：n = 4
* 输出：3
* */
public class Fib_509 {
    //dp数组版
    public int fib1(int n) {
        if(n <= 1) return n;
        //从0开始，需要n+1个位置存
        int[] dp = new int[n + 1];
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    //状态压缩
    public int fib2(int n) {
        if(n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for(int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }



    //递归版，效率低
    public int fib(int n) {
        if(n == 0) {
            return 0;
        }else if(n == 1) {
            return 1;
        }else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Fib_509().fib(4));
    }
}
