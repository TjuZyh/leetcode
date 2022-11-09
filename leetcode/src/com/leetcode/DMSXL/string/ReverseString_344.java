package com.leetcode.DMSXL.string;

/**
 * @Author zyh
 * @Date 2022/11/9 22:58
 * @Version 1.0
 */
/*
* 原地修改输入数组，使用O(1)空间解决问题
*   输入：s = ["h","e","l","l","o"]
*   输出：["o","l","l","e","h"]
* */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        for(int left = 0, right = s.length - 1; left < right ; left++, right--) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }

    public static void main(String[] args) {
        new ReverseString_344().reverseString(new char[]{'h','e','l','l','o','o'});
    }
}
