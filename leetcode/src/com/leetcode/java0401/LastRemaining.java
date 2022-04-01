package com.leetcode.java0401;

import java.util.ArrayList;
import java.util.List;

/*
* 约瑟夫环
* 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。
* 求出这个圆圈里剩下的最后一个数字。
* */
public class LastRemaining {
    /*
    * 利用ArrayList
    * */
    public static int lastRemaining(int n, int m) {
        int flag = (m - 1) % n;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            list.add(i);
        }
        while(list.size() != 1){
            list.remove(flag);
            flag = (flag + m - 1) % list.size();
        }
        return list.get(0);
    }
    /*
    * 动态规划
    *   1.状态定义：设i,m问题的解为dp[i]
    *   2.转移方程：dp[i] = (dp[i - 1] + m) % i
    *   3.初始状态：i,m问题的解恒为0 ， dp[1] = 0
    *   4.返回值：返回为题的解dp[n]
    * */
    public static int lastRemaining1(int n, int m) {
        int[] dp = new int[n+1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + m) % i;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining1(10, 17));
    }
}
