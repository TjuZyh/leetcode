package com.leetcode.java0320;

import com.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/*
* 输入两个链表，找出它们的第一个公共节点
* */
public class GetIntersectionNode {
    /*
    * 数学问题：利用双指针思想
    *   假设headA中不相交的节点个数为a，相交的节点个数为c;
    *      headB中不相交的节点个数为b，相交的节点个数为c;
    *   1. 如果 a=b，则两个指针会同时到达两个链表的第一个公共节点，此时返回两个链表的第一个公共节点；
    *   2. 如果 a != b,则指针la会遍历完链表headA，指针lb会遍历完链表headB，两个指针不会同时到达链表的尾节点，
    *       然后指针la 移到链表headB 的头节点，指针lb 移到链表headA 的头节点，然后两个指针继续移动，在指针la 移动了a+c+b 次、指针 lb 移动了b+c+a 次之后，
    *       两个指针会同时到达两个链表的第一个公共节点，该节点也是两个指针第一次同时指向的节点，此时返回两个链表的第一个公共节点。
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode la = headA , lb = headB;
        while(la != lb){
            if(la != null){
                la = la.next;
            }else {
                la = headB;
            }
            if(lb != null){
                lb = lb.next;
            }else {
                lb = headA;
            }
        }
        return la;
    }

    /*
    * hash + set
    * */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        //初始化set集合
        while(temp != null){
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            if(set.contains(temp)){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

}
