package com.leetcode.offer.java0327;

/*
* 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句
* */
public class SumNums {
    public int sumNums(int n) {
        if(n == 0) return 0;
        else return n + sumNums(n - 1);
    }
}
