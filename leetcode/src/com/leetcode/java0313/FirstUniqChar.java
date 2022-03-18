package com.leetcode.java0313;

import java.util.HashMap;

/*
* 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
* */
public class FirstUniqChar {
    //创建一维数组作为hash表进行存储，这样会浪费空间
    public static char firstUniqChar(String s) {
        int[] hash = new int[26];
        for(int i = 0 ; i < s.length() ; i++){
            int pos = s.charAt(i) - 'a';
            hash[pos]++;
        }

        for(int i = 0 ; i < s.length() ; i++){
            int pos = s.charAt(i) - 'a';
            if(hash[pos] == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }

    //创建Map存储字符，节省空间
    public static char firstUniqChar1(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            //getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
            hashMap.put(ch , hashMap.getOrDefault(ch , 0) + 1);
        }

        for(int i = 0 ; i < s.length() ; i++){
            if(hashMap.get(s.charAt(i)) == 1){
                return s.charAt(i);
            }
        }
        return ' ';
    }



    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(firstUniqChar(str));
    }

}
