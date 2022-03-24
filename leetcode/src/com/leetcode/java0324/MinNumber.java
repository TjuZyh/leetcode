package com.leetcode.java0324;

import java.util.Arrays;

/*
* 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
*   输入: [3,30,34,5,9]
*   输出: "3033459"
 * */
public class MinNumber {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0 ; i < strs.length ; i++){
            strs[i] = String.valueOf(nums[i]);
        }
        //自定义排序规则，拼接两个字符串，比较两种顺序拼接的大小
        Arrays.sort(strs , (x , y) -> (x + y).compareTo(y + x));
        //StringBuilder和StringBuffer的区别
        //运行速度 StringBuilder>StringBuffer>String （StringBuffer有锁，所以性能会降低)
        //StringBuffer线程是安全的，适合多线程；StringBuilder线程是不安全的，适合单线程
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : strs){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
}
