package com.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public static ListNode constructListByArray(int[] arr){
        int n = arr.length;
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for(int i = 1; i < n; i++){
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

}
