package com.leetcode.java0307;

public class CanConstruct2 {

    /*
    * 解题思路：利用暴力解法，用ransomNote中的字符去寻找magazine中的字符；
    *   如果匹配，则在ransomNote中将该字符删除；最终遍历完magazine后，ransomNote长度为0，则匹配成功
    * */
    public static boolean canConstruct(String ransomNote, String magazine) {
        for(int i = 0 ; i < magazine.length() ; i++){
            for(int j = 0 ; j < ransomNote.length() ; j++){
                if(magazine.charAt(i) == ransomNote.charAt(j)){
                    if(ransomNote.length() == 1){
                        return true;
                    }
                    ransomNote = ransomNote.substring(0 , j) + ransomNote.substring(j + 1);
                    break;
                }
            }
        }

        return ransomNote.length() == 0;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aabb", "abb"));
    }
}
