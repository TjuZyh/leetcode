package com.leetcode.offer.java0402;

import java.util.Stack;

/*
* offer31：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
* */
public class ValidateStackSequences {
    /*
    * 模拟
    * */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //借用一个辅助栈 stack ，模拟 压入 / 弹出操作的排列。根据是否模拟成功，即可得到结果
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        //顺序遍历压栈序列
        //循环出栈，若栈顶元素 = 弹出序列元素，则将当前元素出栈，并索引i++
        for(int num : pushed){
            stack.push(num);
            while(!stack.isEmpty() && stack.peek() == popped[i]){
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}
