package com.leetcode.DMSXL_2.linkedList;

import com.leetcode.ListNode;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-29
 */
/*
* 给定一个链表的头节点  head ，返回链表开始入环的第一个节点
*   输入：head = [3,2,0,4], pos = 1
*   输出：1
* */
public class DetectCycle_142 {
    //3 -> 2 -> 0
    //     \   /
    //       4
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(true) {
            if(fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        /*
        * 数学证明：
        *   假设三个变量：x,y,z，其中x表示从head到入环点，y表示入环点到相遇点，z表示相遇点到入环点
        *   fast一次走两步，slow一次走一步
        *   那么，2(x + y) = x + n(y + z) + y，令 n = 1，那么 x = z
        * */
        fast = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(new DetectCycle_142().detectCycle(head).val);

    }
}
