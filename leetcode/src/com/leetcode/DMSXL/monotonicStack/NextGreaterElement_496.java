package com.leetcode.DMSXL.monotonicStack;

import java.util.*;

/**
 * @Author zyh
 * @Date 2023/2/5 21:19
 * @Version 1.0
 */
/*
* nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素
* 存在返回更大元素，不存在返回-1
*   输入：nums1 = [4,1,2], nums2 = [1,3,4,2]
*   输出：[-1,3,-1]
* */
public class NextGreaterElement_496 {
    /*
    * 题意为寻找右侧第一个大于该元素的值，想到单调栈解决
    *   维护栈底到栈顶单调递减的单调栈即可，操作方式：
    *   1.比栈顶大的元素就处理栈顶元素直到栈空或比栈顶元素小
    *   2.比栈顶元素小就直接入栈
    * */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                int curNum = stack.poll();
                map.put(curNum, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()) {
            map.put(stack.poll(), -1);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new NextGreaterElement_496().nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }
}
