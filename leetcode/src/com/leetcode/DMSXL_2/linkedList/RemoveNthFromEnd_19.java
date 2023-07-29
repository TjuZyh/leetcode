package com.leetcode.DMSXL_2.linkedList;

import com.leetcode.ListNode;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-29
 */
/*
* 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
*   输入：head = [1,2,3,4,5], n = 2
*   输出：[1,2,3,5]
* */
public class RemoveNthFromEnd_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode newRoot = new ListNode(-1);
        newRoot.next = head;
        ListNode slow = newRoot, fast = newRoot;
        //-1 1 2 3 4 5
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return newRoot.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.constructListByArray(new int[]{1,2,3,4,5});
        System.out.println(new RemoveNthFromEnd_19().removeNthFromEnd(head, 5));
    }
}
