package com.leetcode.java0318;

import java.util.HashMap;
import java.util.Map;

/*
* 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
* */
public class LengthOfLongest {
    /*
    * 动态规划：
    *   状态定义：dp[j] 代表以字符s[j]结尾的最长不重复子串的长度
    *   转移方程：dp[j] = dp[j - 1] + 1 (无相同字符)
    *                   j - i (有相同字符 ，s[i]为s[j]左侧最近的相同字符)
    * */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = dic.getOrDefault(s.charAt(j), -1); // 获取索引 i
            dic.put(s.charAt(j), j); // 更新哈希表
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "pwwkew";
    }

}
