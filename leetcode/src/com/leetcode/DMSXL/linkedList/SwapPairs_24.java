package com.leetcode.DMSXL.linkedList;

import com.leetcode.ListNode;

/**
 * @Author zyh
 * @Date 2022/10/26 22:08
 * @Version 1.0
 */
/*
* 两两交换相邻的节点
*   输入：head = [1,2,3,4]
*   输出：[2,1,4,3]
* */
public class SwapPairs_24 {
    /*
    * 迭代，核心代码：
    *   l1 -> l2 -> l3
    *       目前只有l1节点 那么 l2 = l1.next
    *   翻转l1 -> l2
    *       l1.next = l2.next; //将l3赋值到l1.next
    *       l2.next = l1;
    * */
    public ListNode swapPairs(ListNode head) {
        ListNode newRoot = new ListNode(-1);
        newRoot.next = head;
        ListNode temp = newRoot;
        while(temp.next != null && temp.next.next != null){
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            temp.next = second;
            first.next = second.next;
            second.next = first;
            temp = first;
        }
        return newRoot.next;
    }
    /*
    * 递归
    * */
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head.next;
        head.next = swapPairs2(newHead.next);
        newHead.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        System.out.println(new SwapPairs_24().swapPairs(ListNode.constructListByArray(new int[]{1, 2, 3, 4, 5, 6})));
    }
}
