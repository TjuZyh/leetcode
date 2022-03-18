package com.leetcode.java0318;

/*
*给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
* 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
* */
public class TranslateNum {
    /*
    * 动态规划：
    *   定义状态：dp[i]表示0-i位能翻译出字符的个数
    *   状态转移方程：dp[i] = dp[i - 1] + dp[i - 2](当最后两位可以翻译)
    *   初始化：dp[0] = 1
    *   输出：dp[len - 1]
    * */
    public static int translateNum(int num) {
        String str = String.valueOf(num);
        int[] dp = new int[str.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2 ; i <= str.length() ; i++){
            String lastTwoStr = str.substring(i-2,i);
            if(lastTwoStr.compareTo("25") <= 0 && lastTwoStr.compareTo("10") >= 0){
                dp[i] = dp[i - 1] + dp[i - 2];
            }else{
                dp[i] = dp[i - 1];
            }

        }
        return dp[str.length()];
    }

    /*
    * 动态规划：滑动数组实现
    * */
    public static int translateNum1(int num) {
        String str = String.valueOf(num);
        int a = 1 , b = 1;
        for(int i = 2 ; i <= str.length() ; i++){
            String temp = str.substring(i - 2 , i);
            int c = temp.compareTo("25") <= 0 && temp.compareTo("10") >= 0 ? a + b : a ;
            b = a;
            a = c;
        }
        return a;
    }


    public static void main(String[] args) {
        int num = 25;
        System.out.println(translateNum(num));

       /* int num1 = 624;
        System.out.println(translateNum(num1));*/
    }
}
