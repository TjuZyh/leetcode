package com.leetcode.DailyCheckIn._0816;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/8/16 11:01
 * @Version 1.0
 */
public class OrderedStream_1656 {
    private int ptr;
    private String[] map;

    public OrderedStream_1656(int n) {
        ptr = 1;
        map = new String[n + 2];
    }

    public List<String> insert(int idKey, String value) {
        map[idKey] = value;
        List<String> ans = new ArrayList<>();
        if(idKey == ptr){
            while(map[ptr] != null){
                ans.add(map[ptr]);
                ++ptr;
            }
            return ans;
        }
        return new ArrayList<>();
    }
}
