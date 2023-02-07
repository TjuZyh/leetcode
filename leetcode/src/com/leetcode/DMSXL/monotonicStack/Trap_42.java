package com.leetcode.DMSXL.monotonicStack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2023/2/6 21:49
 * @Version 1.0
 */
/*
* 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
*   输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
*   输出：6
* */
public class Trap_42 {
    /*
    * 单调栈，栈中存储下标，高度一次递减，若当前高度大于栈顶高度，且栈中元素至少有两个，则可以得到接雨水的区域
    *   该区域的宽度为（当前高度对应下标 - 距栈顶第二个元素下标 - 1）
    *   该区域的高度为（当前元素与第二个元素的高度最小值）- 栈顶高度
    * 将当前栈顶元素出栈，继续比较栈顶元素，以此类推
    * */
    public int trap(int[] height) {
        int ans = 0;
        Deque<Integer> stack = new LinkedList<>();
        int len = height.length;
        for(int i = 0; i < len; i++) {
            while(!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.poll();
                //栈顶元素弹出后，若栈为空，则证明左侧隔不住水，直接退出，将当前高者压入
                if(stack.isEmpty()) {
                    break;
                }
                int second = stack.peek();
                int curWidth = i - second - 1;
                int curHeight = Math.min(height[second], height[i]) - height[top];
                ans += curHeight * curWidth;
            }
            stack.push(i);
        }
        return ans;
    }


}
