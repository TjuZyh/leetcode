package com.leetcode.DailyCheckIn._0308;


import com.leetcode.ListNode;

import java.util.Stack;


public class MiddleNode {
    /*
     * 解题思路：利用栈存入数据的同时记录链表的长度，后求出中间位置索引，遍历到链表中间即可
     * */
    public ListNode middleNode(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode newHead = head;
        int cnt = 0;

        while(newHead != null){
            stack.push(newHead);
            newHead = newHead.next;
            cnt++;
        }
        int middleFlag = cnt / 2 + 1;
        for(int i = 1 ; i < middleFlag ; i++){
            head = head.next;
        }
        return head;
    }

    /*
    * 解题思路：利用快慢指针，和回文列表题类似，注意慢指针的位置以及注意链表为基数和偶数的情况
    * */
    public ListNode middleNode1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
