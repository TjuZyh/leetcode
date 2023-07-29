package com.leetcode.DMSXL_2.linkedList;

import com.leetcode.ListNode;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-29
 */
/*
* 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表
*   输入：head = [1,2,3,4,5]
*   输出：[5,4,3,2,1]
* */
public class ReverseList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        //null 1 -> 2 -> 3
        while(cur != null) {
            ListNode next = cur.next;
            //null <- 1 2 -> 3
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.constructListByArray(new int[]{1,2,3,4,5});
        System.out.println(new ReverseList_206().reverseList(head));
    }
}
