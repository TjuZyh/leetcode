package com.leetcode.offer.java0404;

/*
* 利用数组维护队列
* */
public class MaxQueue {
    /*
    * 定义begin以及end指针，来操作数组，实现出队以及入队
    * */
    int[] queue = new int[20000];
    int begin = 0 , end = 0;

    public MaxQueue() {

    }

    public int max_value() {
        int max = -1;
        for(int i = begin ; i != end ; i++){
            max = Math.max(max , queue[i]);
        }
        return max;
    }

    public void push_back(int value) {
        queue[end++] = value;
    }

    public int pop_front() {
        if(begin == end){
            return -1;
        }
        return queue[begin++];
    }
}
