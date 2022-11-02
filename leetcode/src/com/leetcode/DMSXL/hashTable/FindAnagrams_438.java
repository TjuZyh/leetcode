package com.leetcode.DMSXL.hashTable;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/11/2 11:50
 * @Version 1.0
 */

public class FindAnagrams_438 {
    /*
    * 时间超限，原因：维护了全局的哈希表，需要动态维护哈希表，即滑动一个单词需要动态改变哈希表中存的值
    * */
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length()) {
            return new ArrayList<>();
        }
        int pLen = p.length();
        int sLen = s.length();
        Map<String, List<Integer>> table = new HashMap<>();
        for(int i = 0; i < sLen - pLen + 1; i++){
            //substring两个参数意义：起始位置索引，以及终止位置索引
            String curStr = s.substring(i, i + pLen);
            char[] curChars = curStr.toCharArray();
            Arrays.sort(curChars);
            String key = Arrays.toString(curChars);
            List<Integer> list = table.getOrDefault(key, new ArrayList<>());
            list.add(i);
            table.put(key, list);
        }
        char[] pChars = p.toCharArray();
        Arrays.sort(pChars);
        String pKey = Arrays.toString(pChars);
        return table.getOrDefault(pKey, new ArrayList<>());
    }

    /*
    * 滑动窗口，动态维护哈希表
    *
    *   涉及两个字符串，并要求在长字符串中依据短字符串的特征（长度）寻找子串时，可以采用滑动窗口思想
    * */
    public List<Integer> findAnagrams2(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        if(sLen < pLen) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for(int i = 0; i < pLen; i++){
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }
        if(Arrays.equals(sCount, pCount)){
            ans.add(0);
        }
        //滑动窗口，每移动一个位置，改变一下哈希表
        for(int i = 0; i < sLen - pLen; i++){
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;

            if(Arrays.equals(sCount, pCount)){
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindAnagrams_438().findAnagrams2("abab", "ab"));
        System.out.println("cbaea".substring(2, 2 + 3));
    }


}
