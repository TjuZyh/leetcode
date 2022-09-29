package com.leetcode.DailyCheckIn._0929;

import com.leetcode.DailyCheckIn._0821.IsPrefixOfWord_1455;

/**
 * @Author zyh
 * @Date 2022/9/29 12:59
 * @Version 1.0
 */
public class IisFlipedString_0109 {
    /*
    * s1 = "waterbottle", s2 = "erbottlewat"
    * */
    public boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        for(int i = 0 ; i < s1.length() ; i++){
            String newStr = s1.substring(i) + s1.substring(0 , i);
            if(newStr.equals(s2)){
                return true;
            }
        }
        return false;
    }

    // 如果s2是s1轮转后得到的，则s1 + s1 必定包含s2
    public boolean isFlipedString2(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }


    public static void main(String[] args) {
        System.out.println(new IisFlipedString_0109().isFlipedString("aa", "aba"));
    }
}
