package com.leetcode.offer.java0329;

/*
* 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量)
* */
public class HammingWeight {
    /*
    * 与运算：
    *   若 n & 1 = 0 ,则 n 二进制最右一位为0
    *   若 n & 1 = 1 ,则 n 二进制最右一位为1
    * 移位运算：
    *   n >>>= 1 : 将二进制数字n无符号右移一位
    * */
    public static int hammingWeight(int n) {
        int sum = 0;
        while(n != 0){
            if((n & 1) == 1){
                sum++;
            }
            n >>>= 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(128));
    }
}
