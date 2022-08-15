package com.leetcode.DailyCheckIn._0306;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt2 {

    public static int romanToInt(String s){
        Map<Character , Integer> characterIntegerMap = new HashMap<Character , Integer>(){{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int sum = 0;
        int len = s.length();
        //通常情况下小的数字在大的数字的右边，那么就是相加
        //若小的数字在大的数字右边，就是减去这个小数
        for(int i = 0 ; i < len ; i++){
            int value = characterIntegerMap.get(s.charAt(i));
            if(i < len - 1 && value < characterIntegerMap.get(s.charAt(i + 1))){
                sum -= value;
            }else {
                sum += value;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String s = "LVIII";
        System.out.println(romanToInt(s));
    }

}
