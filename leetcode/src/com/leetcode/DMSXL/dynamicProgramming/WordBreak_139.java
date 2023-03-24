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
*   输入: s = "leetcode", wordDict = ["leet", "code"]
*   输出: true
* */
public class WordBreak_139 {
    /*
    * 完全背包类问题：
    *   1. dp[j]：字符串长度为j时，如果可以拆分为一个或多个出现在单词表中的单词，则为true
    *   2. if([i ,j]区间的子串出现在单词表中 && dp[i] == true) dp[j] = true
    *   3. dp[0] = true
    *   4. 完全背包中的排序问题，所以先正序遍历背包，后正序遍历物品
    * */
    public boolean wordBreak(String s, List<String> wordDict) {
        //可以利用set快速判断单词是否出现在set中
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int j = 1; j <= s.length(); j++) {
            for(int i = 0; i < j && !dp[j]; i++) {
                if(set.contains(s.substring(i, j)) && dp[i]) {
                    dp[j] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
