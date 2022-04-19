package com.leetcode.baseAlgorithm.java0419;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/4/19 9:04 下午
 * @Version 1.0
 */
/*
* 784: 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
*   返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
* */
public class LetterCasePermutation {
    /*
    * 回溯
    * */
    List<String> res = new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        char[] temp = s.toCharArray();
        int len = temp.length;
        backtrace(temp , len , 0);
        return res;
    }

    public void backtrace(char[] temp , int len , int cur){
        res.add(new String(temp));
        for(int i = cur ; i < len ; i++){
            if(!Character.isDigit(temp[i])){
                char curChar = temp[i];
                temp[i] = (char) (temp[i] - 'a' >= 0 ? temp[i] - 32 : temp[i] + 32);
                backtrace(temp , len , i + 1);
                //回溯
                temp[i] = curChar;
            }
        }
    }

    /*
    * 递归：从左往右依次遍历字符，过程中保持 ans 为已遍历过字符的字母大小全排列。
    * eg：abc
    *   1. a A
    *   2. ab Ab aB AB
    *   3. abc Abc aBc ABc abC AbC aBC ABC
    * */
    public List<String> letterCasePermutation1(String s) {
        List<StringBuilder> res = new ArrayList<>();
        res.add(new StringBuilder());

        for(char c : s.toCharArray()){
            int n = res.size();
            if(Character.isLetter(c)){
                for(int i = 0 ; i < n ; i++){
                    res.add(new StringBuilder(res.get(i)));
                    res.get(i).append(Character.toLowerCase(c));
                    res.get(n+i).append(Character.toLowerCase(c));
                }
            }else {
                for(int i = 0 ; i < n ; i++){
                    res.get(i).append(c);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for(StringBuilder stringBuilder : res){
            ans.add(stringBuilder.toString());
        }
        return ans;
    }

}
