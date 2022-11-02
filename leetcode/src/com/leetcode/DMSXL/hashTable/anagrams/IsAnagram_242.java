package com.leetcode.DMSXL.hashTable.anagrams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/10/31 19:51
 * @Version 1.0
 */
/*
* 编写一个函数来判断 t 是否是 s 的字母异位词
*   输入: s = "anagram", t = "nagaram"
*   输出: true
* */
public class IsAnagram_242 {
    /*
    * 哈希表（Map集合实现）
    * */
    public boolean isAnagram(String s, String t) {
        char[] charsForS = s.toCharArray();
        Map<Character, Integer> mapS = new HashMap<>();
        for(char c : charsForS){
            mapS.put(c, mapS.getOrDefault(c, 0) + 1);
        }
        char[] charsForT = t.toCharArray();
        Map<Character, Integer> mapT = new HashMap<>();
        for(char c : charsForT){
            mapT.put(c, mapT.getOrDefault(c, 0) + 1);
        }
        return mapS.equals(mapT);
    }

    /*
    * 哈希表（数组实现，空间复杂度更低）
    *   创建长度为26的数组，str.charAt(i) - 'a'为在哈希表中的索引
    * */
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int[] table = new int[26];
        for(int i = 0; i < s.length(); i++){
            table[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < t.length(); i++){
            table[t.charAt(i) - 'a']--;
            if(table[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }

    /*
    * 直接排序
    * */
    public boolean isAnagram3(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Arrays.sort(charsS);
        Arrays.sort(charsT);
        return Arrays.equals(charsS, charsT);
    }
}
