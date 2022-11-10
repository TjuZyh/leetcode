package com.leetcode.DMSXL.string;

/**
 * @Author zyh
 * @Date 2022/11/10 14:51
 * @Version 1.0
 */
/*
*   输入: s = "abcdefg", k = 2
*   输出: "cdefgab"
* */
public class ReverseLeftWords_offer58 {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords_offer58().reverseLeftWords("abcdefg", 2));
    }
}
