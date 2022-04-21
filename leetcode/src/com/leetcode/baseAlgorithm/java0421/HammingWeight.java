package com.leetcode.baseAlgorithm.java0421;

/**
 * @Author zyh
 * @Date 2022/4/21 2:10 下午
 * @Version 1.0
 */
public class HammingWeight {
    // you need to treat n as an unsigned value

    /*
    * 1 << i : 将1向左移动i位 ， eg：1 << 2 = 100 = 4
    * 一次按位与即可，等于1就计数器加一
    * */
    public int hammingWeight(int n) {
        int res = 0;
        for(int i = 0 ; i < 32 ; i++){
            if((n & (1 << i)) != 0){
                ++res;
            }
        }
        return res;
    }

    /*
    * n & (n - 1) : 将n的二进制的最后一位置为0
    *   eg: n = 6(110) , 110 & 101 = 100
    * 思路：从右到左，依次将末尾的1变为0，直到全部变为0
    * */
    public int hammingWeight1(int n) {
        int res = 0;
        while(n != 0){
            n = n & (n - 1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(1 << 2);
    }
}
