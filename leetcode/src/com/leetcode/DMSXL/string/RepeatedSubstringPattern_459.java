package com.leetcode.DMSXL.string;

/**
 * @Author zyh
 * @Date 2022/11/12 20:09
 * @Version 1.0
 */
/*
* 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成
*   输入: s = "abc"
*   输出: true
* */
public class RepeatedSubstringPattern_459 {
    /*
    * 解题思路：
    *   若字符串为abcabc，那么如果在该字符串后加上自己，那么一定在其中还会出现自己，abc(abcabc)abc
    *   所以可以掐头去尾，判断s + s之中是否存在s，若存在则存在重复构成的子串
    * */
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern_459().repeatedSubstringPattern("abc"));
    }
}
