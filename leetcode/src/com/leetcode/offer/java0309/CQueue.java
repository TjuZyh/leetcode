package com.leetcode.offer.java0309;

import java.util.Stack;

/*
* 用两个栈实现队列的出入队
* */
public class CQueue {
    public CQueue() {

    }

    Stack<Integer> stackOfTemp = new Stack<>();
    Stack<Integer> stackOfOut = new Stack<>();

    public void appendTail(int value) {
        if(!stackOfOut.isEmpty()){
            //将数据存入暂存栈
            while(!stackOfOut.isEmpty()){
                Integer pop = stackOfOut.pop();
                stackOfTemp.push(pop);
            }
            //将新值入栈
            stackOfTemp.push(value);
            //反转
            while(!stackOfTemp.isEmpty()){
                Integer pop = stackOfTemp.pop();
                stackOfOut.push(pop);
            }
        }else {
            stackOfOut.push(value);
        }
    }

    public int deleteHead() {
        if(stackOfOut.isEmpty()){
            return -1;
        }else{
            return stackOfOut.pop();
        }
    }
}
