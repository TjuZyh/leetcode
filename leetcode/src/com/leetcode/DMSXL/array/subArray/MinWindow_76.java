package com.leetcode.DMSXL.array.subArray;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/10/18 20:47
 * @Version 1.0
 */
/*
* 返回最小子数组：s中的子数组包含t中全部字符的最短长度
* 输入：s = "ADOBECODEBANC", t = "ABC"
* 输出："BANC"
* */
public class MinWindow_76 {
    /*
    * 思路是对的，但是这样设计判断t是否在s中时间复杂度过大，时间超限
    *   对于hash表，应该动态的维护，如果在函数里维护，那么每次都会重新创建并维护新的hash，时间空间开销过大
    * */
    public String minWindow(String s, String t) {
        if(s.length() < t.length()){
            return "";
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for(char c : tChars){
            if(!s.contains(String.valueOf(c))){
                return "";
            }
        }
        int left = 0, right = 0, min = Integer.MAX_VALUE;
        String ans = "";
        while(right < sChars.length){
            while(findAllIn(s, t, left, right)){
                if(min > right - left + 1){
                    min = right - left + 1;
                    ans = s.substring(left, right + 1);
                }
                left++;
            }
            right++;
        }
        return ans;
    }

    public boolean findAllIn(String s, String t, int left, int right){
        s = s.substring(left, right + 1);
        Map<Character , Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < t.length() ; i++){
            char cur = t.charAt(i);
            if(map.get(cur) == null){
                return false;
            }else{
                map.put(cur, map.get(cur) - 1);
                if(map.get(cur) < 0){
                    return false;
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        MinWindow_76 minWindow_76 = new MinWindow_76();
        char[] tChats = {'a', 'a'};
        System.out.println(minWindow_76.findAllIn("bba", "aba", 0, 2));
        System.out.println(minWindow_76.minWindow("aa", "aa"));
    }
}
