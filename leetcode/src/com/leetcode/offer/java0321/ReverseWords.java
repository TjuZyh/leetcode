package com.leetcode.offer.java0321;

public class ReverseWords {
    public static String reverseWords(String s) {
        s = s.trim();
        int j = s.length() - 1 , i = j;
        StringBuffer res = new StringBuffer();
        while(i >= 0){
            //搜索首个空格
            while(i >= 0 && s.charAt(i) != ' ') i--;
            //添加单词
            res.append(s.substring(i + 1 , j + 1) + " ");
            //跳过单词空格
            while(i >= 0  && s.charAt(i) == ' ') i--;
            //移动j指针
            j = i;
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        String str = "  the sky   is blue";
        System.out.println(reverseWords(str));
    }
}
