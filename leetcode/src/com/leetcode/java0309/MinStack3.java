package com.leetcode.java0309;

import java.util.Stack;

/*
* 利用辅助栈，维护好辅助栈，使其所有元素降序存储
* */
public class MinStack3 {
    Stack<Integer> A, B;
    public MinStack3() {
        A = new Stack<>();
        B = new Stack<>();
    }
    //添加元素：栈A存储全部元素，栈B存储每一次的小值
    public void push(int x) {
        A.add(x);
        //注意等号这里，因为涉及到出栈，所以相等的值也要压入栈中
        //不加等号：先顺序入栈0-1-0，pop(0)后，栈AB中的0全部弹出，然而当前栈B已经没有元素了
        if(B.empty() || B.peek() >= x)
            B.add(x);
    }
    //出栈时，也要弹出栈B中与之相等的值
    public void pop() {
        if(A.pop().equals(B.peek()))
            B.pop();
    }
    public int top() {
        return A.peek();
    }
    public int min() {
        return B.peek();
    }
}
