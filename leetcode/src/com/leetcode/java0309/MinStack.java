package com.leetcode.java0309;

import java.util.Stack;

public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = (int)(Double.POSITIVE_INFINITY) ;
        Stack<Integer> stackOfTemp = new Stack<>();

        while(!stack.isEmpty()){
            int cur = stack.pop();
            stackOfTemp.push(cur);
            if(cur < min){
                min = cur;
            }
        }
        while(!stackOfTemp.isEmpty()){
            Integer pop = stackOfTemp.pop();
            stack.push(pop);
        }
        return min;
    }
}
