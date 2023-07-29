package com.leetcode.DMSXL_2.linkedList;

import com.leetcode.ListNode;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-29
 */
/*
* 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点
*   输入：listA = [4,1,8,4,5], listB = [5,0,1,8,4,5]
*   输出：8
* */
public class GetIntersectionNode_0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        while(tempA != tempB) {
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode headA = ListNode.constructListByArray(new int[]{4,1});
        ListNode headB = ListNode.constructListByArray(new int[]{5,0,1});
        ListNode headCom = ListNode.constructListByArray(new int[]{8,4,5});

        ListNode tempA = headA;
        for(int i = 0; i < 1; i++) {
            tempA = tempA.next;
        }
        tempA.next = headCom;

        ListNode tempB = headB;
        for(int i = 0; i < 2; i++) {
            tempB = tempB.next;
        }
        tempB.next = headCom;

        System.out.println(new GetIntersectionNode_0207().getIntersectionNode(headA, headB));
    }
}
