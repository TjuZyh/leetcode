package com.leetcode.java0309;

import com.leetcode.ListNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MinStack2 {
    /** initialize your data structure here. */
    List<Integer> list = new ArrayList<>();;
    public MinStack2() {
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int min() {
        int min = (int)(Double.POSITIVE_INFINITY);
        for(Integer i : list){
            if(i < min) min = i;
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack2 minStack2 = new MinStack2();
        minStack2.push(1);
        minStack2.push(3);
        minStack2.push(2);
        System.out.println(minStack2.min());
    }
}

