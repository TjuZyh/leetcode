package com.leetcode.offer.java0403;

/*
* offer67: 写一个函数 StrToInt，实现把字符串转换成整数这个功能
*   数字越界处理
* */
public class StrToInt {
    /*
    * 这种方法会导致越界，不可以找出全部数字部分，再将其直接转换成数字
    * */
    public static int strToInt(String str) {
        if(str == null || str.length() == 0) return 0;
        char[] newStr = str.trim().toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        int flag = 0;
        boolean isNum = false;
        for(int i = 0 ; i < newStr.length ; i++){
            if(newStr[i] >= '0' && newStr[i] <= '9'){
                stringBuilder.append(newStr[i]);
                isNum = true;
            }else if(newStr[i] == '-'){
                if(i != 0){
                    return 0;
                }
                flag = 1;
            }else if(newStr[i] == '+'){
                if(i != 0){
                    return 0;
                }
                continue;
            }else{
                if(i == 0){
                    return 0;
                }
                break;
            }
        }
        int res = 0;
        if(isNum){
            if(Long.parseLong(stringBuilder.toString()) > Integer.MAX_VALUE){
                res = Integer.MAX_VALUE;
                return flag == 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }else{
                res = Integer.parseInt(stringBuilder.toString());
                return flag == 0 ? res : -res;
            }
        }else {
            return 0;
        }
    }

    /*
    * 越界处理：
    *   在每轮数字进行拼接之前，判断res在此轮拼接之后吃否超过2147483647，若超过直接带上符号位返回
    *   存在两种情况越界：
    *       1. res > border
    *       2. res = border && c[j] > '7'
    * */
    public int strToInt1(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        //Integer.MAX_VALUE = 2147483647
        int res = 0 , border = Integer.MAX_VALUE / 10;
        int i = 1 , sign = 1;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i ; j < c.length ; j++){
            if(c[j] < '0' || c[j] > '9'){
                break;
            }
            //存在两种情况越界：
            //    1. res > border , 下一轮 res * 10 必越界
            //    2. res = border && c[j] > '7'
            if(res > border || res == border && c[j] > '7'){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            //字符转换数字技巧：当前字符 - '0'
            res = res * 10 + (c[j] - '0');
        }
        return sign * res;
    }

    public static void main(String[] args) {
        String str = "+-1";
        System.out.println(strToInt(str));
    }
}
