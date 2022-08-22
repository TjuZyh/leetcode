package com.leetcode.DailyCheckIn._0821;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/8/21 11:25
 * @Version 1.0
 */
public class IsPrefixOfWord_1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] sentenceArr = sentence.split(" ");
        for(int i = 0 ; i < sentenceArr.length ; i++){
            if(isPrefix(searchWord , sentenceArr[i])){
                return i + 1;
            }
        }
        return -1;
    }

    public static boolean isPrefix(String search , String origin){
        if(search.length() > origin.length()){
            return false;
        }
        return origin.substring(0, search.length()).equals(search);
    }

    public static void main(String[] args) {
        System.out.println(new IsPrefixOfWord_1455().isPrefixOfWord("hellohello hellohellohello" , "ell"));
    }
}
