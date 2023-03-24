package com.leetcode.DMSXL.backtrack;

import java.util.*;

/**
 * @Author zyh
 * @Date 2023/3/24 23:59
 * @Version 1.0
 */
/*
* 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中
*   输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
*   输出:["cats and dog","cat sand dog"]
* */
public class WordBreak_140 {
    List<String> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();
    Set<String> set;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        backtrack(s, 0);
        return ans;
    }

    public void backtrack(String s, int index) {
        if(index == s.length()) {
            StringBuilder stringBuilder = new StringBuilder();
            for(String str : temp) {
                stringBuilder.append(str);
                stringBuilder.append(" ");
            }
            ans.add(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
        }

        for(int i = index; i < s.length(); i++) {
            if(set.contains(s.substring(index, i + 1))) {
                temp.add(s.substring(index, i + 1));
                backtrack(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String[] str = {"cat","cats","and","sand","dog"};
        List<String> list = Arrays.asList(str);
        System.out.println(new WordBreak_140().wordBreak("catsanddog", list));
    }


}
