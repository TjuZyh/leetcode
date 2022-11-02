package com.leetcode.DMSXL.hashTable;

/**
 * @Author zyh
 * @Date 2022/10/31 23:14
 * @Version 1.0
 */
/*
* 判断 ransomNote 能不能由 magazine 里面的字符构成
*   输入：ransomNote = "aa", magazine = "aab"
*   输出：true
* */
public class CanConstruct_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            table[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            table[ransomNote.charAt(i) - 'a']--;
            if(table[ransomNote.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
