package com.leetcode.DMSXL.linkedList;

import com.leetcode.ListNode;

/**
 * @Author zyh
 * @Date 2023/3/23 15:11
 * @Version 1.0
 */
public class OddEvenList_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head, even = head.next;
        ListNode evenHead = head.next;
        while(even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
