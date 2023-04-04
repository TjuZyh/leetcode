package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/29 10:20
 * @Version 1.0
 */
/*
* 复原IP
*   输入：s = "25525511135"
*   输出：["255.255.11.135","255.255.111.35"]
* */
public class RestoreIpAddresses_087 {
    List<String> ans = new ArrayList<>();
    int[] segments = new int[4];
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return ans;
    }

    public void backtrack(String s, int segId, int segStart) {
        if(segId == 4) {
            if(segStart == s.length()) {
                StringBuilder ipAddr = new StringBuilder();
                for (int i = 0; i < 4; ++i) {
                    ipAddr.append(segments[i]);
                    if (i != 3) {
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }

        if(segStart == s.length()) {
            return;
        }

        //对于前导0的特殊处理
        if(s.charAt(segStart) == '0') {
            segments[segId] = 0;
            backtrack(s, segId + 1, segStart + 1);
        }

        //一位一位的划分，满足条件就继续递归
        int addr = 0;
        for(int i = segStart; i < s.length(); i++) {
            addr = addr * 10 + (s.charAt(i) - '0');
            if(addr > 0 && addr <= 255) {
                segments[segId] = addr;
                backtrack(s, segId + 1, segStart + 1);
            }else {
                break;
            }
        }
    }
}
