package com.leetcode.DMSXL.greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2023/3/6 12:12
 * @Version 1.0
 */
/*
* 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中
*   输入：s = "ababcbacadefegdehijhklij"
*   输出：[9,7,8]
* */
public class PartitionLabels_763 {
    //先统计出各个字符出现的最后位置，记录当前分片的start以及end，若遍历到i == end，则寻找到了一个分片
    //由于end一直取当前存在字符的最大边界，故当i == end时，后面的分片一定不存在当前的字符，保证正确性
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for(int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end) {
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}
