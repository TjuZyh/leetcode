package com.leetcode.DMSXL_2.linkedList;

import com.leetcode.ListNode;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-28
 */
//选择使用单链表或者双链表，设计并实现自己的链表
public class MyLinkedList_707 {
    int size;
    ListNode head;
    public MyLinkedList_707() {
        this.size = 0;
        head = new ListNode(-1);
    }

    //-1 | 1 2 3 index = 2
    public int get(int index) {
        if(index < 0 || index >= size) {
            return -1;
        }
        ListNode temp = head;
        for(int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        index = Math.max(0, index);
        ListNode temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        ListNode node = new ListNode(val);
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    //-1 | 1 2 3 index = 1
    public void deleteAtIndex(int index) {
        if(index < 0 || index > size - 1) {
            return;
        }
        ListNode temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

}
