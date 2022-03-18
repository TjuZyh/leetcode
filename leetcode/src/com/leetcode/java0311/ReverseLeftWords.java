package com.leetcode.java0311;

public class ReverseLeftWords {
    //使用切片函数
    public static String reverseLeftWords(String s, int n) {
        return s == null? s : s.substring(n) + s.substring(0 , n);
    }

    //不使用切片函数
    public static String reverseLeftWords1(String s, int n) {
        StringBuffer res = new StringBuffer();
        for(int i = n ; i < s.length() ; i++){
            res.append(s.charAt(i));
        }
        for(int i = 0 ; i < n ; i++){
            res.append(s.charAt(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverseLeftWords(str, 2));
    }
}
