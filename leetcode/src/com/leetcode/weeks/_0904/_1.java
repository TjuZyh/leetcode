package com.leetcode.weeks._0904;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/9/4 10:23
 * @Version 1.0
 */
//s = "abaccb", distance = [1,3,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
public class _1 {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character , Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i++){
            if(map.get(chars[i]) == null){
                map.put(chars[i] , i);
            }else{
                map.put(chars[i] , i - map.get(chars[i]) - 1);
            }
        }
        for(Character c : map.keySet()){
            //System.out.println(c + " : " + map.get(c));
            int val = c;
            if(map.get(c) == distance[val - 97]){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new _1().checkDistances("aa", new int[]{0, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}
