package com.leetcode.advAlgorithm.java0428;

/**
 * @Author zyh
 * @Date 2022/4/28 10:05 下午
 * @Version 1.0
 */
/*
* 844：给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
* */
public class BackspaceCompare {
    /*
    * 思路一：重构字符串
    * */
    public static boolean backspaceCompare(String s, String t) {
        return backString(s).equals(backString(t));
    }

    public static String backString(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] charArr = str.trim().toCharArray();
        for(int i = 0 ; i < charArr.length ; i++){
            if(charArr[i] == '#'){
                if(stringBuilder.length() != 0){
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
            }else{
                stringBuilder.append(charArr[i]);
            }
        }
        return stringBuilder.toString();
    }

    /*
    * 思路二：双指针
    *   一个字符是否会被删掉，只取决于该字符后面的退格符，而与该字符前面的退格符无关。
    *   因此当我们逆序地遍历字符串，就可以立即确定当前字符是否会被删掉。
    * */
    public boolean backspaceCompare1(String S, String T) {
        int i = S.length() - 1  , j = T.length() - 1;
        int skipS = 0 , skipT = 0;

        while(i >= 0 || j >= 0){
            while(i >= 0){
                if(S.charAt(i) == '#'){
                    skipS++;
                    i--;
                }else if(skipS > 0){
                    skipS--;
                    i--;
                }else {
                    break;
                }
            }
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if(i >= 0 && j >= 0){
                if(S.charAt(i) != T.charAt(j)){
                    return false;
                }
            }else { // 至少有一个出界，包含 1. 都出界（不做处理） 2. 当且仅当一个出界（返回false的第二个条件）
                if(i >= 0 || j >= 0){ // 这行代码表示当且仅当一个出界
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("a#c" , "b"));
    }
}
