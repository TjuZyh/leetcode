package com.leetcode.DMSXL.linkedList;

import com.leetcode.ListNode;

import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/10/24 12:00
 * @Version 1.0
 */
/*
* 翻转链表
*   输入：head = [1,2,3,4,5]
*   输出：[5,4,3,2,1]
* */
public class ReverseList_206 {
    /*
    * 利用栈实现链表翻转
    * */
    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode newRoot = new ListNode(0);
        ListNode temp = newRoot;
        while(head != null){
            stack.add(head);
            head = head.next;
        }
        while(!stack.isEmpty()){
            temp.next = stack.pop();
            temp = temp.next;
        }
        //不加这句会导致循环链表
        //在栈中的节点next会保存之间的next，需要初始化
        temp.next = null;
        return newRoot.next;
    }

    /*
    * 迭代：依次从链表头翻转指针到链表尾
    * */
    public ListNode reverseList2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            //需要暂存一下cur的下一个节点
            ListNode next = cur.next;
            //翻转指针
            cur.next = pre;
            //后移pre以及cur
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /*
    * 递归
    * */
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newRoot = reverseList3(head.next);
        //l1 -> l2 翻转为 l1 <- l2
        head.next.next = head;
        //去引用，初始化
        head.next = null;
        return newRoot;
    }

    public static void main(String[] args) {
        ListNode listNode = ListNode.constructListByArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(new ReverseList_206().reverseList(listNode));
    }
}
