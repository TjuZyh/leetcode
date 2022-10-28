package com.leetcode.DMSXL.linkedList;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/10/27 14:31
 * @Version 1.0
 */
public class GetIntersectionNode_0207 {
    /*
    * 数值相等而不是指针相等
    * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<Integer> list1 = serializeList(headA);
        List<Integer> list2 = serializeList(headB);
        int len1 = list1.size(), len2 = list2.size();
        int ansIndex = -1;
        for(int i = len1 - 1, j = len2 - 1; i > 0 && j > 0; i--, j--){
            if(list1.get(i).equals(list2.get(j))){
                ansIndex = i;
            }else {
                break;
            }
        }
        if(ansIndex == -1){
            return null;
        }else {
            for(int i = 0; i < ansIndex; i++){
                headA = headA.next;
            }
            return headA;
        }
    }

    public List<Integer> serializeList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        return list;
    }
    /*
    * 双指针方法：很巧妙
    *   前提：设headA链表长a，headB链表长b，重合部分长c
    *   a + (b - c) = b + (a - c)
    *   设立双指针分别指向headA与headB，指针tempA遍历完headA，再遍历headB；同时，指针tempB遍历完headB，再遍历headA
    *       当指针重合时，即重合点
    * */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode tempA = headA, tempB = headB;
        while(tempA != tempB){
            tempA = tempA == null ? headB : tempA.next;
            tempB = tempB == null ? headA : tempB.next;
        }
        return tempA;
    }

    public static void main(String[] args) {
        ListNode headA = ListNode.constructListByArray(new int[]{5,1,2});
        ListNode headB = ListNode.constructListByArray(new int[]{5,1,2});
        ListNode tempA = headA;
        ListNode tempB = headB;
        System.out.println(headA == headB);
        System.out.println(new GetIntersectionNode_0207().getIntersectionNode2(headA, headB));
    }
}
