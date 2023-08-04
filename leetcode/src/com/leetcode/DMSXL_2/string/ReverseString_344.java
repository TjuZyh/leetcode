package com.leetcode.DMSXL_2.string;

import java.util.Arrays;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-03
 */
/*
* 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出
*   输入：s = ["h","e","l","l","o"]
*   输出：["o","l","l","e","h"]
* */
public class ReverseString_344 {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }


    public static void main(String[] args) {
        new ReverseString_344().reverseString(new char[]{'h','e','l','l','o'});
        new ReverseString_344().reverseString(new char[]{'i'});
    }

}
