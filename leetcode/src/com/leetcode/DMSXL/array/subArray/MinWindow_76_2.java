package com.leetcode.DMSXL.array.subArray;

import com.sun.corba.se.spi.activation.ActivatorHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/10/18 21:47
 * @Version 1.0
 */
public class MinWindow_76_2 {

    Map<Character, Integer> tMap = new HashMap<>();
    Map<Character, Integer> sMap = new HashMap<>();

    public String minWindow(String s, String t) {
        char[] tChars = t.toCharArray();
        for(char c : tChars){
            if(!s.contains(String.valueOf(c))){
                return "";
            }
        }
        for(int i = 0; i < t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, min = Integer.MAX_VALUE;
        int ansL = 0, ansR = 0;
        while(right < s.length()){
            if(tMap.containsKey(s.charAt(right))){
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while(isIn()){
                if(min > right - left + 1){
                    min = right - left + 1;
                    ansL = left;
                    ansR = right + 1;
                }
                if(tMap.containsKey(s.charAt(left))){
                    sMap.put(s.charAt(left), sMap.get(s.charAt(left)) - 1);
                }
                left++;
            }
            right++;
        }
        return s.substring(ansL, ansR);
    }

    public boolean isIn(){
        for(Character c : tMap.keySet()){
            int tVal = tMap.get(c);
            if(sMap.getOrDefault(c, 0) < tVal){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow_76_2().minWindow("a", "aa"));
    }
}
