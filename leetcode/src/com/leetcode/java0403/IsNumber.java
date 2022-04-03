package com.leetcode.java0403;

/*
* offer20：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）
*   s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.'
* */
public class IsNumber {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) return false;
        // 标记是否遇到数位、小数点、‘e’或'E', 防止二次出现
        boolean isNum = false , isDot = false , ise_or_E = false;
        //将s去前后空格并转换为字符数组
        char[] str = s.trim().toCharArray();
        for(int i = 0 ; i < str.length ; i++){
            if(str[i] >= '0' && str[i] <= '9'){
                isNum = true;
            }else if(str[i] == '.'){
                //如果在小数点前出现过小数点以及e/E，则直接返回false ; 小数点前可以没有数字
                if(isDot || ise_or_E) return false;
                isDot = true;
            }else if(str[i] == 'e' || str[i] == 'E'){
                //e/E之前必须有数字，并且不能重复出现e/E
                if(!isNum || ise_or_E) return false;
                ise_or_E = true;
                //e/E之后也必须有数字，将数字位置为false
                isNum = false;
            }else if(str[i] == '-' || str[i] == '+'){
                //正负号的位置只能出现在第一个位置或者e/E位置之后第一个位置
                if(i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
            }else {
                return false;
            }
        }
        return isNum;
    }
}
