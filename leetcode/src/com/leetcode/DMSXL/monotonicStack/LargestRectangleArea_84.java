package com.leetcode.DMSXL.monotonicStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Author zyh
 * @Date 2023/2/6 22:30
 * @Version 1.0
 */
/*
* 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
*   求在该柱状图中，能够勾勒出来的矩形的最大面积。
* 输入：heights = [2,1,5,6,2,3]
* 输出：10
* */
public class LargestRectangleArea_84 {
    //暴力，针对每一个高度找出向左向右第一个较小高度，计算宽度即可
    public int largestRectangleArea(int[] heights) {
        int area = 0, len = heights.length;
        for(int i = 0; i < len; i++) {
            int curHeight = heights[i];
            int right = i + 1, left = i - 1;
            int width = 0;
            while(left > 0 && heights[left] >= curHeight) {
                width++;
                left--;
            }
            while(right < len && heights[right] >= curHeight) {
                width++;
                right++;
            }
            area = Math.max(area, (width + 1) * curHeight);
            System.out.println(area);
        }
        return area;
    }

    /*
    * 维护一个单调递增栈（栈底到栈顶），记录下标
    * */
    public int largestRectangleArea2(int[] heights) {
        int area = 0;
        //头尾加0很巧妙，解决了首位判空问题以及首部出栈问题
        int[] tmp = new int[heights.length + 2];
        //将heights数组复制到tmp中
        //其中将heights中第0位开始复制，复制到tmp中的第1位，复制长度为 heights.length
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < tmp.length; i++) {
            while(!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                //以栈顶元素的高度作为基准，
                //  当前元素由于小于栈顶元素，则为右边第一个较小元素
                //  栈顶元素出栈，栈中下一个元素也小于栈顶元素（维护的单调递增栈），则为左边第一个较小元素
                int height = tmp[stack.poll()];
                area = Math.max(area, (i - stack.peek() - 1) * height);
            }
            stack.push(i);
        }
        return area;
    }





    public static void main(String[] args) {
        System.out.println(new LargestRectangleArea_84().largestRectangleArea2(new int[]{2, 1, 5, 6, 2, 3}));
    }


}
