package com.leetcode.DMSXL.string;

/**
 * @Author zyh
 * @Date 2022/11/12 19:58
 * @Version 1.0
 */
/*
* 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标
*   输入：haystack = "sadbutsad", needle = "sad"
*   输出：0
* */
public class StrStr_28 {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int lenNeed = needle.length();
        for(int i = 0; i < haystack.length() - lenNeed + 1; i++) {
            System.out.println(i);
            if(haystack.substring(i, lenNeed + i).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    //todo KMP算法实现

    public static void main(String[] args) {
        System.out.println(new StrStr_28().strStr("a", "a"));
    }
}
