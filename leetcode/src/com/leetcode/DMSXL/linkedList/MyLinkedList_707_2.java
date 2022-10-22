package com.leetcode.DMSXL.linkedList;

import com.leetcode.DoubleListNode;

import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/10/22 14:19
 * @Version 1.0
 */
/*
* 双链表实现，空间换时间，维护一个头节点一个尾节点，可以根据index的位置从头或尾进行遍历，加快查询速率
* */
public class MyLinkedList_707_2 {
    private int size;
    private DoubleListNode head;
    private DoubleListNode tail;

    public MyLinkedList_707_2() {
        size = 0;
        head = new DoubleListNode(0);
        tail = new DoubleListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        DoubleListNode curr;
        if(index + 1 < size - index){
            curr = head;
            for(int i = 0; i <= index; i++){
                curr = curr.next;
            }
        }else {
            curr = tail;
            for(int i = 0; i < size - index; i++){
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) return;
        size++;
        index = Math.max(0, index);
        DoubleListNode pred, succ;
        if(index < size - index){
            pred = head;
            for(int i = 0; i < index; i++){
                pred = pred.next;
            }
            succ = pred.next;
        }else {
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }
        DoubleListNode newNode = new DoubleListNode(val);
        newNode.next = succ;
        newNode.prev = pred;
        pred.next = newNode;
        succ.prev = newNode;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        DoubleListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) {
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }
        size--;
        pred.next = succ;
        succ.prev = pred;
    }
}
