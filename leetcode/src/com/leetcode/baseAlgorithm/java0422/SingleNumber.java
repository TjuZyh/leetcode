package com.leetcode.baseAlgorithm.java0422;

/**
 * @Author zyh
 * @Date 2022/4/22 8:09 下午
 * @Version 1.0
 */
/*
* 136：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
* */
public class SingleNumber {
    /*
    * 定理：
    *   交换律：a ^ b ^ c <=> a ^ c ^ b
    *   任何数于0异或为任何数 0 ^ n => n
    *   相同的数异或为0: n ^ n => 0
    * eg:
    *   [2,2,3,4,4] -> 2^2^3^4^4 -> 0^3^0 -> 3
    * */
    public int singleNumber(int[] nums) {
        int single = 0;
        for(int num : nums){
            single ^= num;
        }
        return single;
    }
}
