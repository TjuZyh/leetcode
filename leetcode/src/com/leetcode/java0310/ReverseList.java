package com.leetcode.java0310;

import com.leetcode.ListNode;

import java.util.Stack;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        head = stack.pop();
        ListNode cur = head;
        while(!stack.isEmpty()){
            ListNode temp = stack.pop();
            temp.next = null;
            cur.next = temp;
            cur = temp;
        }
        return head;
    }
}
