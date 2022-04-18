package com.leetcode.baseAlgorithm.java0418;

import com.leetcode.ListNode;

/**
 * @Author zyh
 * @Date 2022/4/18 3:20 下午
 * @Version 1.0
 */
/*
* 21 : 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
* */
public class MergeTwoLists {
    /*
    * 迭代
    * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(-1);
        ListNode newHead = newNode;
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                newNode.next = list1;
                list1 = list1.next;
            }else{
                newNode.next = list2;
                list2 = list2.next;
            }
            newNode = newNode.next;
        }
        while(list1 != null){
            newNode.next = list1;
            list1 = list1.next;
            newNode = newNode.next;
        }
        while(list2 != null){
            newNode.next = list2;
            list2 = list2.next;
            newNode = newNode.next;
        }
        return newHead.next;
    }

    /*
    * 递归
    * */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val <= l2.val){
            l1.next = mergeTwoLists1(l1.next , l2);
            return l1;
        }else{
            l2.next = mergeTwoLists1(l1 , l2.next);
            return l2;
        }
    }
}
