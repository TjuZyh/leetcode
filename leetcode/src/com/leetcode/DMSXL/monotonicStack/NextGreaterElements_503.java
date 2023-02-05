package com.leetcode.DMSXL.monotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author zyh
 * @Date 2023/2/5 21:44
 * @Version 1.0
 */
/*
* 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素
*   输入: nums = [1,2,1]
*   输出: [2,-1,2]
* */
public class NextGreaterElements_503 {
    /*
    * 维护下标单调栈，涉及到循环数组，最多遍历两次即可填充完ans
    * */
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < length * 2 - 1; i++) {
            int curNum = nums[i % length];
            while(!stack.isEmpty() && curNum > nums[stack.peek()]) {
                int preIndex = stack.poll();
                ans[preIndex] = curNum;
            }
            stack.push(i % length);
        }
        return ans;
    }
}
