package com.leetcode.java0307;

public class CanConstruct {
    //ransomNote 能不能由 magazine 里面的字符构成
    //magazine 中的每个字符只能在 ransomNote 中使用一次
    //也就是一个比对字符出现次数的问题

    /*
    * 解题思路：看到了字符匹配的问题，而且字符串顺序是随机的，可以考虑用hash来做
    *   1. 首先用长度为26的数组记录magazine字符串字符出现的次数
    *   2. 再用ransomNote字符串按位去比对数组，如果不包含则返回false
    * */
    public static boolean canConstruct(String ransomNote, String magazine) {
        //用来存储字符串字符出现的次数
        int[] record = new int[26];
        int flag;
        for(int i = 0 ; i < magazine.length() ; i++){
            flag = magazine.charAt(i) - 'a';
            record[flag]++;
        }
        for(int i = 0 ; i < ransomNote.length() ; i++){
            flag = ransomNote.charAt(i) - 'a';

            if(record[flag] > 0){
                record[flag]--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aaab" , "baa"));
    }
}
