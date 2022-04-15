package com.leetcode.baseAlgorithm.java0414;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/4/14 8:58 下午
 * @Version 1.0
 */
/*
* 567: 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。
*   如果是，返回 true ；否则，返回 false 。
* */
public class CheckInclusion {
    /*
    * hash求和：思想可以，空间超限
    * */
    public static boolean checkInclusion(String s1, String s2) {
        int sum = 0;
        for(int i = 0 ; i < s1.length() ; i++){
            sum += s1.charAt(i) * s1.charAt(i);
        }
        System.out.println(sum);
        for(int i = 0 ; i < s2.length()-s1.length() + 1 ; i++){
            int curSum = 0;
            for(int j = i ; j < s1.length() + i ; j++){
                curSum += s2.charAt(j) * s2.charAt(j);
                System.out.println(curSum);
            }
            if(curSum == sum){
                return true;
            }
        }
        return false;
    }

    /*
    * 滑动窗口 + hash
    * */
    public boolean checkInclusion1(String s1, String s2) {
        //hash表存储字符出现的次数
        int[] hashS1 = new int[26];
        int[] hashS2 = new int[26];
        int n = s1.length() , m = s2.length();
        if(n > m){
            return false;
        }
        //初始化hash表
        for(int i = 0 ; i < n ; i++){
            ++hashS1[s1.charAt(i) - 'a'];
            ++hashS2[s2.charAt(i) - 'a'];
        }
        if(Arrays.equals(hashS1 , hashS2)){
            return true;
        }
        for(int i = n ; i < m ; i++){
            ++hashS2[s2.charAt(i) - 'a'];
            --hashS2[s2.charAt(i - n) - 'a'];
            if(Arrays.equals(hashS1 , hashS2)){
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(checkInclusion(s1 , s2));
    }

}
