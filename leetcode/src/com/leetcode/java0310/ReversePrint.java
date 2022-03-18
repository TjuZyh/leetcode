package com.leetcode.java0310;

import com.leetcode.ListNode;

import java.util.Stack;

public class ReversePrint {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int cnt = 0;
        while(head != null){
            stack.push(head.val);
            head = head.next;
            cnt++;
        }
        int[] result = new int[cnt];
        int i = 0;
        while(!stack.isEmpty()){
            result[i++] = stack.pop();
        }
        return result;
    }
}
