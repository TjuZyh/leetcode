package com.leetcode.offer.java0328;

/*
* 计算 x 的 n 次幂函数（即，x^n）
* */
public class MyPow {
    /*
    * 超时
    * */
    public static double myPow(double x, int n) {
        double pow = 1;
        if(n > 0){
            for(int i = n ; i > 0 ; i--){
                pow *= x;
            }
            return pow;
        }else if(n < 0){
            int sum = Math.abs(n);
            for(int i = sum ; i > 0 ; i--){
                pow *= x;
            }
            return 1 / pow;
        }else {
            return 0;
        }
    }

    /*
    * 快速幂
    *   x^n = (x^2)^(n/2), n/2需要分为奇偶进行讨论
    *   1. 偶数：x^n = (x^2)^(n/2)
    *   2. 奇数：x^n = x(x^2)^(n/2) 多出一个x
    * */
    public double myPow1(double x, int n) {
        if(x == 0) return 0;
        long b = n;
        double res = 1.0;
        /*
        * 指数为负数的情况，需要调整一下
        * */
        if(b < 0){
            x = 1/x;
            b = -b;
        }
        while (b > 0){
            //(b & 1) == 1 相当于 (b % 2) == 1
            //如果为奇数，则需要多乘一个x
            if((b & 1) == 1) res *= x;
            //底数平方
            x *= x;
            //右移一位，相当于除2
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,10));
    }
}
