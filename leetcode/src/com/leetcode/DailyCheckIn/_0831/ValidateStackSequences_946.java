package com.leetcode.DailyCheckIn._0831;

import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/8/31 21:01
 * @Version 1.0
 */
public class ValidateStackSequences_946 {
    /*
    * 创建一个栈，不断压入pushed数组中的元素
    *   如果栈顶元素与当前popped数组上元素相等，则不断删除栈顶元素;
    *   最终判断栈是否为空即可，空则可以满足栈进出顺序
    * */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for(int i = 0 ; i < pushed.length ; i++){
            stack.add(pushed[i]);
            while(!stack.isEmpty() && stack.peek() == popped[popIndex]){
                stack.pop();
                ++popIndex;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] popped = {4,5,3,1,2};
        System.out.println(new ValidateStackSequences_946().validateStackSequences(pushed, popped));
    }


}
