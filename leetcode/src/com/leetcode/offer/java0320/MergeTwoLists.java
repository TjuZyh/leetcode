package com.leetcode.offer.java0320;

import com.leetcode.ListNode;

/*
* 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
* */
public class MergeTwoLists {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newList = new ListNode(-1) , pre = newList;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            }else{
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        //合并剩余尾部
        if(l1 != null){
            pre.next = l1;
        }
        if(l2 != null){
            pre.next = l2;
        }

        return newList.next;
    }

    /*
    * 递归
    * */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        //如果l1节点值比l2小，下一个节点应该是l1，应该return l1;
        //在return之前，指定l1的下一个节点应该是l1.next和l2俩链表的合并后的头结点
        if(l1.val <= l2.val){
            l1.next = mergeTwoLists1(l1.next , l2);
            return l1;
        }else {
            l2.next = mergeTwoLists1(l1 , l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        ListNode listNode4 = new ListNode(0);
        ListNode listNode5 = new ListNode(0);
        ListNode listNode6 = new ListNode(1);
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        ListNode newNode = mergeTwoLists(listNode1, listNode4);
        while(newNode != null){
            System.out.print(newNode.val + " -> ");
            newNode = newNode.next;
        }


    }


}
