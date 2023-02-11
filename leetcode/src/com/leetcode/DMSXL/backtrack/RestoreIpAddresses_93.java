package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/11 21:35
 * @Version 1.0
 */
/*
* 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址
*   输入：s = "25525511135"
*   输出：["255.255.11.135","255.255.111.35"]
* */
public class RestoreIpAddresses_93 {
    List<String> ans = new ArrayList<>();
    int[] segments = new int[4];
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return ans;
    }

    public void backtrack(String s, int segId, int begin) {
        //已经找到4段，且正好遍历到最后一位
        if(segId == 4) {
            if(begin == s.length()) {
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 0; i < 4; i++) {
                    stringBuilder.append(segments[i]);
                    if(i != 3) {
                        stringBuilder.append('.');
                    }
                }
                ans.add(stringBuilder.toString());
            }
            return;
        }
        //未找到4段，就已经遍历到尾部
        if(begin == s.length()) {
            return;
        }

        //如果当前为0，那么只能认定为一段
        if(s.charAt(begin) == '0') {
            segments[segId] = 0;
            backtrack(s, segId + 1, begin + 1);
        }

        int addr = 0;
        for(int i = begin; i < s.length(); i++) {
            addr = addr * 10 + (s.charAt(i) - '0');
            if(addr > 0 && addr <= 255) {
                segments[segId] = addr;
                backtrack(s, segId + 1, i + 1);
            }else {
                break;
            }
        }
    }


}
