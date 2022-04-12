package com.leetcode.baseAlgorithm.java0412;

import java.util.Arrays;

/*
* 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
* */
public class ReverseWords {
    public static String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : s.trim().split(" ")) {
            char[] temp = str.toCharArray();
            reverseString(temp);
            //append方法可以直接输入一个char类型数组
            stringBuilder.append(temp).append(" ");
        }
        return stringBuilder.toString().trim();
    }

    public static void reverseString(char[] s) {
        int left = 0 , right = s.length - 1;
        while(left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        //char[]转string
        char[] c = {'a' , 'b' , 'c'};
        String str = String.valueOf(c);
        System.out.println(str);
    }
}
