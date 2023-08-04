package com.leetcode.DMSXL_2.string;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-04
 */
/*
* 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成
*   输入: s = "abab"
*   输出: true
*
*   输入: s = "aba"
*   输出: false
* */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, s.length() * 2 - 1).contains(s);
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("aba"));
    }
}
