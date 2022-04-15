package com.leetcode.baseAlgorithm.java0414;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author zyh
 * @Date 2022/4/14 8:19 下午
 * @Version 1.0
 */
/*
* 3. 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度
* */
public class LengthOfLongestSubstring {
    /*
    * 滑动窗口 + set
    * */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int right = -1 , maxLen = 0;
        //每次将i位置当做字符串的开始，去寻找当前的最大值，移动窗口要移动
        for(int i = 0 ; i < s.length() - maxLen ; i++){
            //这样做相当于保留了原来的set集，只需要每次移动一位就可以
            if(i != 0){
                set.remove(s.charAt(i - 1));
            }
            while(right + 1 < s.length() && !set.contains(s.charAt(right + 1))){
                set.add(s.charAt(right + 1));
                ++right;
            }
            maxLen = Math.max(maxLen , right - i + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "dvdf";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
