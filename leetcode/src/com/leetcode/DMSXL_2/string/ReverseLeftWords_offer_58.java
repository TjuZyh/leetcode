package com.leetcode.DMSXL_2.string;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-04
 */
/*
* 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部
*   输入: s = "lrloseumgh", k = 6
*   输出: "umghlrlose"
* */
public class ReverseLeftWords_offer_58 {
    public String reverseLeftWords(String s, int n) {
        String first = s.substring(0, n);
        String last = s.substring(n);

        return last+ first;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseLeftWords_offer_58().reverseLeftWords("lrloseumgh", 6));
    }
}
