package com.leetcode.java0308;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {
    //创建小顶堆
    @Test
    public void test1(){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });

        priorityQueue.offer(2);
        priorityQueue.offer(1);
        priorityQueue.offer(4);
        priorityQueue.offer(3);

        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }

    //利用lambda表达式创建大顶堆
    @Test
    public void test2(){
        PriorityQueue<String> priorityQueue = new PriorityQueue<>((s1 , s2) -> {
            return -s1.compareTo(s2);
        });
    }
}
