package com.leetcode.offer.java0311;

public class ReplaceSpace {
    //输入：s = "We are happy."
    //输出："We%20are%20happy."
    public static String replaceSpace(String s) {
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == ' '){
                s = s.substring(0 , i) + "%20" + s.substring(i + 1);
                i += 2;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        String str = "     ";
        str = replaceSpace(str);
        System.out.println(str);
    }
}
