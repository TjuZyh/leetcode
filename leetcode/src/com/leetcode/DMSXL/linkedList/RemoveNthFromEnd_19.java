package com.leetcode.DMSXL.linkedList;

import com.leetcode.DoubleListNode;
import com.leetcode.ListNode;

/**
 * @Author zyh
 * @Date 2022/10/26 22:42
 * @Version 1.0
 */
/*
* 删除链表中第n个节点
*   输入：head = [1,2,3,4,5], n = 2
*   输出：[1,2,3,5]
* */
public class RemoveNthFromEnd_19 {
    /*
    * 先获取链表的总长度，后确定删除位置删除即可
    * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getListLen(head);
        ListNode newRoot = new ListNode(-1);
        newRoot.next = head;
        ListNode temp = newRoot;
        while(len - n > 0){
            len--;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return newRoot.next;
    }

    public int getListLen(ListNode head){
        int len = 0;
        ListNode temp = head;
        while (temp != null){
            temp = temp.next;
            len++;
        }
        return len;
    }
    /*
    * 双指针：
    *   first指针与second指针相隔n个距离，后同时移动双指针，当first遍历到尾部时，second.next位置即为删除位置
    *
    * 一般需要寻找倒数n个位置时，可以利用双指针寻找：
    *   first指针先移动与second指针相隔n个距离，后同时移动双指针，当first移动到尾部时，second即为倒是第n个位置
    * */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode newRoot = new ListNode(-1);
        newRoot.next = head;
        ListNode first = head;
        ListNode second = newRoot;
        for(int i = 0; i < n; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return newRoot.next;
    }


    public static void main(String[] args) {
        System.out.println(new RemoveNthFromEnd_19().removeNthFromEnd(ListNode.constructListByArray(new int[]{1, 2, 3, 4, 5}), 2));
        System.out.println(new RemoveNthFromEnd_19().getListLen(ListNode.constructListByArray(new int[]{1,2,3,4})));
    }
}
