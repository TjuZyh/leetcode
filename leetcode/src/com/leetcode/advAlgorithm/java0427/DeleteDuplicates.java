package com.leetcode.advAlgorithm.java0427;

import com.leetcode.ListNode;

import java.util.List;

/**
 * @Author zyh
 * @Date 2022/4/27 7:52 下午
 * @Version 1.0
 */
/*
* 82: 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
* */
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //创建一个空节点，无需考虑首节点被删除的情况
        ListNode newHead = new ListNode(-1 , head);
        ListNode cur = newHead;
        //cur.next为原来的head
        while(cur.next != null && cur.next.next != null){
            if(cur.next.next.val == cur.next.val){
                //获取当前值
                int curVal = cur.next.val;
                //如果相等就删除该节点，包含了自己也删除
                while(cur.next != null && cur.next.val == curVal){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return newHead.next;
    }
}
