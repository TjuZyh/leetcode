package com.leetcode.baseAlgorithm.java0421;

import com.sun.media.sound.SF2Region;

/**
 * @Author zyh
 * @Date 2022/4/21 1:49 下午
 * @Version 1.0
 */
/*
* 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
*   如果存在一个整数 x 使得n == 2^x ，则认为 n 是 2 的幂次方。
* */
public class IsPowerOfTwo {
    /*
    * 递归
    * */
    public boolean isPowerOfTwo(int n) {
        if(n == 1) return true;
        if(n == 0) return false;
        if(n % 2 != 0) return false;
        return isPowerOfTwo(n / 2);
    }
    /*
    * 位运算：
    *   2的幂次运算在二进制下，只有一位是1，其余都为0（8 : 00001000）
    *   负数的在计算机中二进制表示为补码(原码->正常二进制表示，原码按位取反(0-1,1-0)，最后再+1
    *       eg：-8 : 11110111 + 1 -> 11111000
    *   本题思路：原码&补码，如果等于原码就证明为2的幂次
    *       eg：8 & -8 -> 00001000 & 11111000 -> 00001000 -> 8
    * */
    public boolean isPowerOfTwo1(int n) {
        return (n > 0) && (n & -n) == n;
    }

    public boolean isPowerOfTwo2(int n) {
        //eg n = 8;
        //00001000 & 00000111 = 0
        return (n > 0) && (n & (n - 1)) == 0;
    }

}
