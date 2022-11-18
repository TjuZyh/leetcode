package com.leetcode.DMSXL.stack_queue;

import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/11/15 22:24
 * @Version 1.0
 */
/*
* 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们
* 在 S 上反复执行重复项删除操作，直到无法继续删除
*   输入："abbaca"
*   输出："ca"
* */
public class RemoveDuplicates_1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }else {
                stack.push(c);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }

    /*
    * 使用StringBuilder当做栈模拟栈的功能
    * */
    public String removeDuplicates2(String s) {
        StringBuilder stack = new StringBuilder();
        int top = -1;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                top--;
            }else {
                stack.append(ch);
                top++;
            }
        }
        return stack.toString();
    }


    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates_1047().removeDuplicates("abbaca"));
    }
}
