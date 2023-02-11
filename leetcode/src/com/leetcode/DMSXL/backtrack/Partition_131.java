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
    boolean[][] map;

    public List<List<String>> partition(String s) {
        //判读回文串用到了动态规划
        map = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            Arrays.fill(map[i], true);
        }

        for (int i = s.length() - 1; i >= 0; --i) {
            for (int j = i + 1; j < s.length(); ++j) {
                map[i][j] = (s.charAt(i) == s.charAt(j)) && map[i + 1][j - 1];
            }
        }

        backtrack(s, 0);
        return ans;
    }

    //判断i-j是否为回文串，是则加入，并继续判断j+1开始的后序子串
    public void backtrack(String s, int i) {
        if(i == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int j = i; j < s.length(); j++) {
            if(map[i][j]) {
                temp.add(s.substring(i, j + 1));
                backtrack(s, j + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }


}
