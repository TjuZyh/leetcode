package com.leetcode.java0306;

import com.leetcode.ListNode;

import java.util.Stack;

public class Palindrome2 {
    /*
    * 解题思路：由于看到了回文序列，即序列有反转的性质，那么就可以想到用栈来解决
    *   1. 创建栈，将链表中的数依次压入
    *   2. 依次出栈与链表对比即可
    *
    * */
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode newHead = head;
        //将链表的数全部压入栈中
        while(newHead != null){
            stack.push(newHead.val);
            newHead = newHead.next;
        }

        //依次出栈与链表对比
        while(head != null){
            if(stack.pop() != head.val){
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
