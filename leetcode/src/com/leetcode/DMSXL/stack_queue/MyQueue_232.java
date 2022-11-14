package com.leetcode.DMSXL.stack_queue;

/**
 * @Author zyh
 * @Date 2022/11/14 22:43
 * @Version 1.0
 */

import java.util.Stack;

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
public class MyQueue_232 {
    Stack<Integer> inputStack;
    Stack<Integer> outputStack;

    public MyQueue_232() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(int x) {
        inputStack.push(x);
    }

    //每次pop时，都去输出栈看一下是否有数据，若没有则将输入栈中的数据push进来
    //需要pop或peek时，维护一下两个栈即可
    public int pop() {
        if(outputStack.isEmpty()) {
            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.pop();
    }

    public int peek() {
        if(outputStack.isEmpty()) {
            while(!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.peek();
    }

    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }
}
