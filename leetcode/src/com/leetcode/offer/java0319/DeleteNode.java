package com.leetcode.offer.java0319;

import com.leetcode.ListNode;

/*
* 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
*   返回删除后的链表的头节点。
* */
public class DeleteNode {
    /*
    * 输入: head = [4,5,1,9], val = 1
    * 输出: [4,5,9]
    * */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode newHead = head;
        //特判：若为头结点，直接返回next即可
        if(newHead.val == val){
            head = head.next;
            return head;
        }
        while(newHead != null){
            if(newHead.next.val == val){
                newHead.next = newHead.next.next;
                break;
            }
            newHead = newHead.next;
        }
        return head;
    }
}
