package com.leetcode.offer.java0329;

/*
* 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
* */
public class Add {
    /*
    * 和 = 非进位和 + 进位
    * */
    public int add(int a, int b) {
        while(b != 0){
            //与运算，计算进位c
            int c = (a & b) << 1;
            //异或运算，计算无进位和
            a = a ^ b;
            //将进位赋值给b
            b = c;
        }
        return a;
    }
}
