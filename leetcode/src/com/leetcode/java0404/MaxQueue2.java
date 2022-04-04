package com.leetcode.java0404;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
* 创建队列用于实现队列；同时利用双端队列维护一个单调队列，单调队列的队首即为最大值
* */
public class MaxQueue2 {
    Queue<Integer> queue;
    Deque<Integer> deque;

    public MaxQueue2() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if(deque.isEmpty()){
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        while(!deque.isEmpty() && deque.peekLast() < value){
            deque.pollLast();
        }
        deque.offerLast(value);
        queue.offer(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int ans = queue.poll();
        if(ans == deque.peekFirst()){
            deque.pollFirst();
        }
        return ans;
    }
}
