package com.leetcode.baseAlgorithm.java0413;

import com.leetcode.ListNode;

/*
* 876：给定一个头结点为 head 的非空单链表，返回链表的中间结点。
*   如果有两个中间结点，则返回第二个中间结点。
* */
public class MiddleNode {
    /*
    * 快慢指针
    * */
    public ListNode middleNode(ListNode head) {
        ListNode fast = head , slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
