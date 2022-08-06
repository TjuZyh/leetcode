package com.leetcode.DailyCheckIn._0806;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author zyh
 * @Date 2022/8/6 12:44
 * @Version 1.0
 */
public class StringMatching_1408 {
    /*
    * 暴力
    *   可以使用String类中的contains方法直接判断包含关系
    * */
    public List<String> stringMatching(String[] words) {
        List<String> ansList = new ArrayList<>();
        Set<String> ansSet = new HashSet<>();
        for(int i = 0 ; i < words.length ; i++){
            for(int j = i + 1 ; j < words.length ; j++){
                String curAns = isContain(words[i] , words[j]);
                if(curAns != null){
                    ansSet.add(curAns);
                }
            }
        }
        for(String str : ansSet){
            ansList.add(str);
        }
        return ansList;
    }

    public static String isContain(String str1 , String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        if(len1 < len2){
            for(int i = 0 ; i < len2 - len1 + 1 ; i++){
                if(str2.substring(i , i + len1).equals(str1)){
                    return str1;
                }
            }
        }else if(len1 > len2){
            for(int i = 0 ; i < len1 - len2 + 1 ; i++){
                if(str1.substring(i , i + len2).equals(str2)){
                    return str2;
                }
            }
        }else{
            return str1.equals(str2) ? str1 : null;
        }
        return null;
    }

    public static void main(String[] args) {
        new StringMatching_1408().stringMatching(new String[]{"mass","as","hero","superhero"}).stream().forEach(System.out::println);
    }
}
