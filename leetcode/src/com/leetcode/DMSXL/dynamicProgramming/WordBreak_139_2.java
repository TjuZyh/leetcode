package com.leetcode.DMSXL.dynamicProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author zyh
 * @Date 2023/3/24 18:48
 * @Version 1.0
 */
/*
* 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s
*   输入: s = "applepenapple", wordDict = ["apple", "pen"]
*   输出: true
* */
public class WordBreak_139_2 {
    //记忆化回溯
    Set<String> set;
    int[] memory;
    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memory = new int[s.length()];
        return backtrack(s, 0);
    }

    public boolean backtrack(String str, int index) {
        if(index == str.length()) {
            return true;
        }
        if(memory[index] == -1) {
            return false;
        }
        for(int i = index; i < str.length(); i++) {
            String curSubStr = str.substring(index, i + 1);
            if(!set.contains(curSubStr)) {
                continue;
            }
            boolean res = backtrack(str, i + 1);
            if(res) {
                return true;
            }
        }
        //index - str.length找遍也没有完全匹配，那么标记从index开始不能找到
        memory[index] = -1;
        return false;
    }
}
