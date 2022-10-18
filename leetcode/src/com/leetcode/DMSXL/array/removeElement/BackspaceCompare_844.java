package com.leetcode.DMSXL.array.removeElement;

/**
 * @Author zyh
 * @Date 2022/10/17 16:43
 * @Version 1.0
 */
/*
* 输入：s = "ab#c", t = "ad#c"
* 输出：true
* */
public class BackspaceCompare_844 {
    public boolean backspaceCompare(String s, String t) {
        return getString(s).equals(getString(t));
    }

    public String getString(String s){
        int left = 0, right = 0;
        char[] chars = s.toCharArray();
        while(right < chars.length){
            if(chars[right] != '#'){
                if(left < 0){
                    left++;
                    continue;
                }
                chars[left] = chars[right];
                left++;
            }else {
                left--;
            }
            right++;
        }
        if(left < 0){
            return "";
        }else {
            return new String(chars).substring(0, left);
        }
    }

    public static void main(String[] args) {
        System.out.println(new BackspaceCompare_844().getString("hd#dp#czsp#######"));
    }
}
