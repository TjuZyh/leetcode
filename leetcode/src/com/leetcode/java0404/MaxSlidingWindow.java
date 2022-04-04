package com.leetcode.java0404;


import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
* 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
* */
public class MaxSlidingWindow {
    /*
    * 单调队列
    * */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int j = 0 , i = 1 - k ; j < nums.length ; i++ , j++){
            // 删除 deque 中对应的 nums[i-1]
            if(i > 0 && deque.peekFirst() == nums[i - 1]){
                deque.removeFirst();
            }
            //队列不为空时，当前值与队列尾部值比较，如果大于，删除队列尾部值
            //一直循环删除到队列中的值都大于当前值，或者删到队列为空
            while(!deque.isEmpty() && deque.peekLast() < nums[j]){
                deque.removeLast();
            }
            //执行完上面的循环后，队列中要么为空，要么值都比当前值大，然后就把当前值添加到队列中
            deque.addLast(nums[j]);
            if(i >= 0){
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    /*
    * 优先队列
    * */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        if(nums.length == 0 || k == 0) return new int[0];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
    }
}
