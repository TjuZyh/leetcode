package com.leetcode.DMSXL_2.linkedList;

import com.leetcode.ListNode;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-28
 */
/*
* 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点
*   输入：head = [1,2,6,3,4,5,6], val = 6
*   输出：[1,2,3,4,5]
* */
public class RemoveElements_203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode newRoot = new ListNode(-1);
        newRoot.next = head;
        ListNode temp = newRoot;
        while(temp != null) {
            if(temp.next.val == val) {
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return newRoot.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.constructListByArray(new int[]{1, 2, 6, 3, 4, 5, 6});
        System.out.println(new RemoveElements_203().removeElements(head, 6));
    }
}
