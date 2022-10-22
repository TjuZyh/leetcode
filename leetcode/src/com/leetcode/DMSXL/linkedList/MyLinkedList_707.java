package com.leetcode.DMSXL.linkedList;

import com.leetcode.ListNode;

import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/10/22 13:45
 * @Version 1.0
 */
/*
* 利用单链表作为底层数据结构，实时维护链表的长度size，用于判定index合法性
* */
public class MyLinkedList_707 {
    private int size;
    private ListNode head;

    public MyLinkedList_707() {
        size = 0;
        head = new ListNode(0);
    }

    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        ListNode cur = head;
        for(int i = 0; i <= index; i++){
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /*
    * 三种情况：
    *   1. index等于链表长度，即将该节点附加到链表尾
    *   2. index大于链表长度，则不插入节点
    *   3. index小于0，则在头部插入节点
    * */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        size++;
        index = Math.max(0, index);
        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
    }

    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }
        size--;
        ListNode pre = head;
        for(int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }

    public static void main(String[] args) {
        MyLinkedList_707 linkedList = new MyLinkedList_707();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }
}
