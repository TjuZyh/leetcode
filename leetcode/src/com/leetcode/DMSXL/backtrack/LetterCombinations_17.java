package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2023/2/9 20:33
 * @Version 1.0
 */
/*
* 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回
*   输入：digits = "23"
*   输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
* */
public class LetterCombinations_17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) {
            return ans;
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");

        backtrack(0, digits, phoneMap, ans, new StringBuilder());
        return ans;
    }

    public void backtrack(int index, String digits, Map<Character, String> phoneMap, List<String> ans, StringBuilder temp) {
        if(index == digits.length()) {
            ans.add(temp.toString());
        }else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int len = letters.length();
            //要区分index和i的关系
            //i表示当前选取数字中的哪一个字符
            //index表示选取哪一个数字
            for(int i = 0; i < len; i++) {
                temp.append(letters.charAt(i));
                backtrack(index + 1, digits, phoneMap, ans, temp);
                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }
}
