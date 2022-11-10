package com.leetcode.DMSXL.string;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/11/10 13:49
 * @Version 1.0
 */
/*
* 给你一个字符串 s ，请你反转字符串中 单词 的顺序
*   输入：s = "a good   example"
*   输出："example good a"
* */
public class ReverseWords_151 {
    public String reverseWords(String s) {
        String[] split = cutSpace(s).split(" ");
        int left = 0, right = split.length - 1;
        while(left < right) {
            String temp = split[left];
            split[left] = split[right];
            split[right] = temp;
            left++;
            right--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : split) {
            stringBuilder.append(str);
            stringBuilder.append(" ");
        }
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }

    public String cutSpace(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        s = s.trim();
        for(int i = 0; i < s.length(); i++) {
            stringBuilder.append(s.charAt(i));
            if(s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
                while (s.charAt(i + 1) == ' ') {
                    i++;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords_151().cutSpace("  a good   example"));
        System.out.println(Arrays.toString("  a good   example".trim().split(" ")));
        System.out.println(new ReverseWords_151().reverseWords("  a good   example"));
    }
}
