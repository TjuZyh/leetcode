package com.leetcode.DMSXL.string;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/11/9 23:19
 * @Version 1.0
 */
/*
* 每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符
*   输入：s = "abcdefg", k = 2
*   输出："bacdfeg"
* */
public class ReverseStr_541 {
    /*
    * 先封装k区间内翻转字符串的API，后每次移动到新区间即可
    * */
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        //每次移动2k个位置
        for(int i = 0; i < n; i += 2 * k) {
            reverse(chars, i , Math.min(i + k, n) - 1);
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
