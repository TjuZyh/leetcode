package com.leetcode.DMSXL.linkedList;

import com.leetcode.DMSXL.array.removeElement.RemoveElement_27;
import com.leetcode.ListNode;

import java.util.List;

/**
 * @Author zyh
 * @Date 2022/10/20 22:55
 * @Version 1.0
 */
/*
* 在链表中删除元素
* 输入：head = [1,2,6,3,4,5,6], val = 6
* 输出：[1,2,3,4,5]
* */
public class RemoveElements_203 {
    /*
    * 迭代
    * */
    public ListNode removeElements(ListNode head, int val) {
        //创建一个新头指针的目的：不用讨论head为空的情况或被删除的情况
        ListNode newRoot = new ListNode(-1);
        newRoot.next = head;
        ListNode temp = newRoot;
        while(temp.next != null){
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }else {
                temp = temp.next;
            }
        }
        return newRoot.next;
    }

    /*
    * 递归
    * */
    public ListNode removeElements2(ListNode head, int val) {
        if(head == null){
            return null;
        }
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        new RemoveElements_203().removeElements(node1, 6);
    }
}
