package com.leetcode.DMSXL_2.string;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-03
 */
/*
* 请实现一个函数，把字符串 s 中的每个空格替换成"%20"
*   输入：s = "We are happy."
*   输出："We%20are%20happy."
* */
public class ReplaceSpace_offer_05 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c : chars) {
            if(c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceSpace_offer_05().replaceSpace("We are happy."));
    }
}
