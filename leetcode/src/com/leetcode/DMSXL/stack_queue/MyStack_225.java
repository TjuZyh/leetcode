package com.leetcode.DMSXL.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author zyh
 * @Date 2022/11/14 22:56
 * @Version 1.0
 */
public class MyStack_225 {
    //queue1存储栈内的元素
    //queue2作为入栈操作的辅助队列
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack_225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        if(!queue1.isEmpty()) {
            return queue1.poll();
        }else {
            return -1;
        }
    }

    public int top() {
        if(!queue1.isEmpty()) {
            return queue1.peek();
        }else {
            return -1;
        }
    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}
