package com.leetcode.DailyCheckIn._0815;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/8/15 10:54
 * @Version 1.0
 */

/*
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
public class MyCircularDeque_641 {
    /*
    * 利用数组作为数据结构，设立front以及rear指针，以及capacity个存储空间
    *   判空：front == rear
    *   判满：front == (rear + 1) % capacity
    *   当前容量：(rear - front + capacity) % capacity
    * */
    private int[] elements;
    private int rear , front;
    private int capacity;

    public MyCircularDeque_641(int k) {
        capacity = k + 1;
        rear = front = 0;
        elements = new int[k + 1];
    }

    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }
        front = (front - 1 + capacity) % capacity;
        elements[front] = value;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }
        elements[rear] = value;
        rear = (rear + 1) % capacity;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }
        front = (front + 1) % capacity;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }
        rear = (rear - 1 + capacity) % capacity;
        return true;
    }

    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return elements[front];
    }

    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return elements[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }
}
