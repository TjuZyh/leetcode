package com.leetcode.DMSXL_2.hashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-01
 */
/*
* 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词
*   输入: s = "anagram", t = "nagaram"
*   输出: true
* */
public class IsAnagram_242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Character c : t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0) {
                    map.remove(c);
                }
            }else {
                return false;
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new IsAnagram_242().isAnagram("anagram", "naaram"));
    }
}
