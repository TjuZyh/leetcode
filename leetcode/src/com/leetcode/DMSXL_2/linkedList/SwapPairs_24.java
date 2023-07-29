package com.leetcode.DMSXL_2.linkedList;

import com.leetcode.ListNode;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-29
 */
/*
* 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点
*   输入：head = [1,2,3,4]
*   输出：[2,1,4,3]
* */
public class SwapPairs_24 {
    public ListNode swapPairs(ListNode head) {
        ListNode newRoot = new ListNode(-1);
        newRoot.next = head;
        ListNode temp = newRoot;
        while(temp.next != null && temp.next.next != null) {
            //-1 -> 1 -> 2 -> 3
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            //-1 -> 2 -> 3
            //      ^
            //      1
            temp.next = second;
            //-1 -> 2  1 -> 3
            first.next = second.next;
            //-1 -> 2 -> 1 -> 3
            second.next = first;
            temp = first;
        }
        return newRoot.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.constructListByArray(new int[]{1,2,3,4,5});
        System.out.println(new SwapPairs_24().swapPairs(head));
    }
}
