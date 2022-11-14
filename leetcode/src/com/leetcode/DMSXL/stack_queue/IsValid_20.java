package com.leetcode.DMSXL.stack_queue;

import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/11/14 23:12
 * @Version 1.0
 */
public class IsValid_20 {
    /*
    * 方法好笨...
    * */
    public boolean isValid(String s) {
        char[] chars = {'(', ')', '{', '}', '[', ']'};
        Stack<Integer> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == chars[0] || c == chars[2] || c == chars[4]) {
                if(c == chars[0]) {
                    stack.push(0);
                }else if(c == chars[2]) {
                    stack.push(2);
                }else {
                    stack.push(4);
                }
            }else {
                int cur = -1;
                if(c == chars[1]) {
                    cur = 0;
                }else if(c == chars[3]) {
                    cur = 2;
                }else {
                    cur = 4;
                }
                if(!stack.isEmpty() && stack.peek() == cur) {
                    stack.pop();
                }else {//这种情况一定不会匹配了，所以一直判false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            }else if(c == '[') {
                stack.push(']');
            }else if(c == '{') {
                stack.push('}');
            }else { // ) ] }
                if(!stack.isEmpty() && stack.peek() == c){
                    stack.pop();
                }else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(new IsValid_20().isValid2("([{}])"));
    }
}
