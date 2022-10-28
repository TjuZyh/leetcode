package com.leetcode.DMSXL.linkedList;

import com.leetcode.ListNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author zyh
 * @Date 2022/10/28 16:44
 * @Version 1.0
 */
public class DetectCycle_142 {
    /*
    * 利用hash表，记录已经访问过的节点，若再次访问存在环
    * */
    public ListNode detectCycle(ListNode head) {
        ListNode temp = head;
        Set<ListNode> visited = new HashSet<>();
        while(temp != null){
            if(visited.contains(temp)){
                return temp;
            }else {
                visited.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }

    /*
    * 哈希表用list集合也可以
    * */
    public ListNode detectCycle2(ListNode head) {
        ListNode temp = head;
        List<ListNode> l = new ArrayList<>();
        while(temp != null){
            if(l.contains(temp)){
                return temp;
            }else {
                l.add(temp);
            }
            temp = temp.next;
        }
        return null;
    }

    /*
    * 双指针思想：具体理论部分可以看题解
    *   1.寻找第一次相遇位置（若有环存在）
    *   2.slow继续从相遇位置移动，fast从链表头移动，同时一个一个移动，相遇位置为环入口
    * */
    public ListNode detectCycle3(ListNode head) {
        ListNode fast = head, slow = head;
        while(true) {
            if(fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) break;
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
