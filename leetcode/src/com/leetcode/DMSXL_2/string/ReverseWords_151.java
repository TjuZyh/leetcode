package com.leetcode.DMSXL_2.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-04
 */
/*
* 给你一个字符串 s ，请你反转字符串中 单词 的顺序
*   输入：s = " the sky  is blue"
*   输出："blue is sky the"
* */
public class ReverseWords_151 {
    public String reverseWords(String s) {
        String[] words = preProcessString(s);

        int left = 0, right = words.length - 1;
        while(left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        return Arrays.toString(words);
    }

    private String[] preProcessString(String s) {
        List<String> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] != ' ') {
                StringBuilder cur = new StringBuilder();
                cur.append(chars[i]);
                i++;
                while(i < chars.length && chars[i] != ' ') {
                    cur.append(chars[i]);
                    i++;
                }
                ans.add(cur.toString());
            }
        }
        String[] res = new String[ans.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords_151().reverseWords("  the   sky  is   blue "));
    }
}
