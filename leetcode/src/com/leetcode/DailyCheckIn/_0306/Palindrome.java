package com.leetcode.DailyCheckIn._0306;


import com.leetcode.ListNode;

import java.util.Stack;

public class Palindrome {
    //1 -> 2 -> 3 -> 3 -> 2 -> 1
    /*
    解题思路：
    1. 首先利用快慢指针，快指针每次走两个，慢指针每次走一个，找出链表的中间位置
    2. 将链表的后半部分翻转，（涉及链表翻转的知识）
    3. 依次对比前后两部分对应位置是否相等即可
    */

    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        slow = reverse(slow.next);
        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverse(ListNode head){
        ListNode newHead = null;
        while(head != null){
            ListNode remain = head.next;
            head.next = newHead;
            newHead = head;

            head = remain;
        }
        return newHead;
    }

    //利用栈实现链表反转
    private ListNode reverse1(ListNode head){
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        while(newHead != null){
            stack.push(newHead);
            newHead = newHead.next;
        }

        head = stack.pop();
        //这里不能直接操作head，因为要返回链表头head
        ListNode cur = head;
        while(!stack.isEmpty()){
            //创建新节点
            ListNode node = stack.pop();
            //去引用，存入栈时还保留之前的链接关系
            node.next = null;
            //与链表链接
            cur.next = node;
            //移动指针，准备链接下一个新节点
            cur = node;
        }
        return head;
    }



}


