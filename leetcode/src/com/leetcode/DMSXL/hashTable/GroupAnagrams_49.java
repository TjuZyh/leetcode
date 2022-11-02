package com.leetcode.DMSXL.hashTable;

import javax.swing.*;
import java.util.*;

/**
 * @Author zyh
 * @Date 2022/10/31 23:24
 * @Version 1.0
 */
/*
* 给你一个字符串数组，请你将 字母异位词 组合在一起
*   输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
*   输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
* */
public class GroupAnagrams_49 {
    /*
    * 将字符串排序后作为key，相同的key放入一个list中
    * */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> table = new HashMap<>();
        for(String str : strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = Arrays.toString(chars);
            List<String> list = table.getOrDefault(key, new ArrayList<>());
            list.add(str);
            table.put(key, list);
        }
        /*List<List<String>> ans = new ArrayList<>();
        for(String key: table.keySet()){
            ans.add(table.get(key));
        }
        return ans;*/
        return new ArrayList<>(table.values());
    }
    /*
    * 方法1利用排序作为map中的key，可以用计数的方式作为key
    *   例如：abb key为a1b2
    * */
    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> table = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(int i = 0; i < str.length(); i++){
                count[str.charAt(i) - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0; i < 26; i++){
                if (count[i] != 0) {
                    stringBuilder.append((char) ('a' + i));
                    stringBuilder.append(count[i]);
                }
            }
            String key = stringBuilder.toString();
            List<String> list = table.getOrDefault(key, new ArrayList<>());
            list.add(str);
            table.put(key, list);
        }
        return new ArrayList<>(table.values());
    }

}
