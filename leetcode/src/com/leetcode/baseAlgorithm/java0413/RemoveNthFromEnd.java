package com.leetcode.baseAlgorithm.java0413;

import com.leetcode.ListNode;

/*
* 19：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
* */
public class RemoveNthFromEnd {
    /*
    * 计算链表长度，锁定删除位置
    * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode newNode = head;
        while(newNode != null){
            newNode = newNode.next;
            len++;
        }
        ListNode otherNode = head;
        int curDelete = len - n - 1;
        //删除头节点
        if(len == n){
            return head.next;
        }
        while(curDelete-- > 0){
            otherNode = otherNode.next;
        }
        //删除当前位置的节点
        otherNode.next = otherNode.next.next;
        return head;
    }

    /*
    * 双指针：
    *   first指针比second指针超前n个节点，当first指针遍历到表尾时，second正好指向删除节点
    * */
    public ListNode removeNthFromEnd1(ListNode head, int n){
        //防止被删除的节点是头结点，可以现创建一个新节点
        //这样做的目标避免讨论了头结点被删除的情况
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        while(n-- > 0){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
