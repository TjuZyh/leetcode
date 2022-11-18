package com.leetcode.DMSXL.stack_queue;

import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * @Author zyh
 * @Date 2022/11/17 22:47
 * @Version 1.0
 */
/*
* 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧，返回滑动窗口中的最大值
*   输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
*   输出：[3,3,5,5,6,7]
* */
public class MaxSlidingWindow_239 {
    /*
    * 维护一个大根堆，可以用优先队列实现
    *   在优先队列中记录元素值以及索引，并且无需每次移动都删除不在滑动窗口中的元素
    * */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //new int[元素，索引]
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        //将前k个元素入队
        for(int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        //从第k个元素开始遍历
        for(int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            //判断当前最大的元素是否在滑动窗口内，如果不在就poll，直到找到在滑动窗口内的最大值
            //请注意，这里不是移动一次滑动窗口就poll一次，也无法这样做，因为无法确定移出滑动窗口的元素
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    /*
    * 单调队列，维护数组中的下标，使元素单调递减
    * */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<>();
        //使得元素在deque中是单调递减
        //添加一个元素时，先将比其小的元素删除，后入队
        for(int i = 0; i < k; i++) {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for(int i = k; i < n; i++) {
            while(!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            //如果最大值不在滑动窗口内，则删除
            while(deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }

}
