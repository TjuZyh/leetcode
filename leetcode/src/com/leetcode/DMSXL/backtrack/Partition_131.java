package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/11 11:16
 * @Version 1.0
 */
/*
* 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
* */
public class Partition_131 {
    List<List<String>> ans = new ArrayList<>();
    List<String> temp = new ArrayList<>();


    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return ans;
    }

    //判断i-j是否为回文串，是则加入，并继续判断j+1开始的后序子串
    public void backtrack(String s, int index) {
        if(index >= s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                String str = s.substring(index, i + 1);
                temp.add(str);
            }else {
                continue;
            }
            backtrack(s, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        for(int i = start, j = end; i < j; i++, j--) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }


}
