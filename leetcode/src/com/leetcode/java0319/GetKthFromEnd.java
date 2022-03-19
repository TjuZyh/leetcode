package com.leetcode.java0319;

import com.leetcode.ListNode;

/*
* 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
* */
public class GetKthFromEnd {
    /*
    * 顺序查找：遍历出链表的长度，再遍历到 len-k 位置即可
    * */
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int len = 0;
        ListNode flag = head;
        while(flag != null){
            flag = flag.next;
            len++;
        }
        for(int i = 1 ; i <= len - k ; i++){
            head = head.next;
        }
        return head;
    }

    /*
    * 双指针：设立快慢指针，两个指针之间相隔k，当快指针遍历到链表尾时，满指正好到达倒数第k位置
    * */
    public static ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && k > 0){
            fast = fast.next;
            k--;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(getKthFromEnd(listNode1 , 2).val);
    }
}
