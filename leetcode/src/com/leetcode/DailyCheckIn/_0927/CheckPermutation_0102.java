package com.leetcode.DailyCheckIn._0927;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/9/27 10:55
 * @Version 1.0
 */
/*
* 确定其中一个字符串的字符重新排列后，能否变成另一个字符串
*
* 输入: s1 = "abc", s2 = "bca"
* 输出: true
* */
public class CheckPermutation_0102 {
    /*
    * hash
    * */
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Map<Character , Integer> map1 = new HashMap<>();
        for (char c : chars1) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        Map<Character , Integer> map2 = new HashMap<>();
        for (char c : chars2) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }

        for(Character c : map1.keySet()){
            if(!map1.get(c).equals(map2.get(c))){
                return false;
            }
        }
        return true;
    }

    /*
    * hash简化版
    * */
    public boolean CheckPermutation2(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s1.length() ; i++){
            Character c = s1.charAt(i);
            map.put(c , map.getOrDefault(c , 0) + 1);
        }
        for(int i = 0 ; i < s2.length() ; i++){
            Character c = s2.charAt(i);
            if(map.get(c) == null){
                return false;
            }else {
                if(map.get(c) - 1 < 0){
                    return false;
                }
                map.put(c , map.get(c) - 1);
            }

            if(map.getOrDefault(c, 0) - 1 < 0){
                return false;
            }
        }
        return true;
    }

    /*
    * 排序
    * */
    public boolean CheckPermutation3(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1 , chars2);
    }

    public static void main(String[] args) {
        System.out.println(new CheckPermutation_0102().CheckPermutation2("abb", "aab"));

    }

}
