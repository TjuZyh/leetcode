package com.leetcode.DailyCheck._202210._1004;

import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/10/4 10:53
 * @Version 1.0
 */
public class MinAddToMakeValid_921 {
    /*
    * 括号匹配：栈实现
    * 输入：s = "((("
    * 输出：3
    * */
    public int minAddToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char cur = s.charAt(i);
            if(cur == '('){
                stack.add(1);
            }else {
                if(!stack.isEmpty()){
                    stack.pop();
                }else {
                    ans++;
                }
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
            ans++;
        }
        return ans;
    }

    public int minAddToMakeValid2(String s) {
        int ans = 0;
        int leftCnt = 0;
        for(char c : s.toCharArray()){
            if(c == '(') {
                leftCnt++;
            }else {
                if(leftCnt > 0){
                    leftCnt--;
                }else if(leftCnt == 0){
                    ans++;
                }
            }
        }
        return leftCnt + ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinAddToMakeValid_921().minAddToMakeValid2(")("));
    }
}
