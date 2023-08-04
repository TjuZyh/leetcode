package com.leetcode.DMSXL_2.string;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-04
 */
/*
* 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
*   如果 needle 不是 haystack 的一部分，则返回 -1
* 输入：haystack = "sadbutsad", needle = "sad"
* 输出：0
* */
public class StrStr_28 {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for(int i = 0; i < haystack.length() - len + 1; i++) {
            if(haystack.substring(i, len + i).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new StrStr_28().strStr("asadbutsad", "sad"));
    }
}
