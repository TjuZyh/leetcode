package com.leetcode.baseAlgorithm.java0422;

/**
 * @Author zyh
 * @Date 2022/4/22 8:05 下午
 * @Version 1.0
 */
/*
* 190: 颠倒给定的 32 位无符号整数的二进制位。
* */
public class ReverseBits {
    // you need treat n as an unsigned value
    /*
    * 将 n 视作一个长为 32 的二进制串，从低位往高位枚举 n 的每一位，将其倒序添加到翻转结果 rev 中
    * */
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
