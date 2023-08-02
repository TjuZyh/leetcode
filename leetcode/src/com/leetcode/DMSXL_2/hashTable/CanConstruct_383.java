package com.leetcode.DMSXL_2.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-02
 */
/*
* 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成
*   输入：ransomNote = "aa", magazine = "aab"
*   输出：true
* */
public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character c : ransomNote.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanConstruct_383().canConstruct("baa", "aaaaaab"));
    }
}
