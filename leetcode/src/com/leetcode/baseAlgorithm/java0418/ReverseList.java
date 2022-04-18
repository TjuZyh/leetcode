package com.leetcode.baseAlgorithm.java0418;

import com.leetcode.ListNode;

import java.util.Stack;

/**
 * @Author zyh
 * @Date 2022/4/18 4:06 下午
 * @Version 1.0
 */
public class ReverseList {
    /*
    * 栈
    * */
    public ListNode reverseList(ListNode head) {
        if(head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while(head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = stack.pop();
        ListNode newNode = newHead;
        while(!stack.isEmpty()){
            ListNode curNode = stack.pop();
            curNode.next = null;
            newNode.next = curNode;
            newNode = newNode.next;
        }
        return newHead;
    }

    /*
    * 迭代：在遍历链表时，将当前节点的 next 指针改为指向前一个节点。
    *   由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
    *   在更改引用之前，还需要存储后一个节点。最后返回新的头引用。
    * */
    public ListNode reverseList1(ListNode head) {
        ListNode preNode = null;
        ListNode curNode = head;
        while(curNode != null){
            ListNode nextNode = curNode.next;
            curNode.next = preNode;
            //由于节点没有引用其前一个节点，因此必须事先存储其前一个节点。
            preNode = curNode;
            //更新游标
            curNode = nextNode;
        }
        return preNode;
    }

    /*
    * 递归:
    *   面对与这种情况，指针处于nk：
    *       n1 -> n2 -> ... -> nk-1 -> nk -> nk+1 <- ... <= nm
    *   那么，目标是nk+1的下一个节点指向nk
    *       应该为：nk.next.next = nk; //nk.next 为 nk+1, 那么nk.next.next 为 nk+1.next
    * */
    public ListNode reverseList2(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode newNode = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newNode;
    }
}
