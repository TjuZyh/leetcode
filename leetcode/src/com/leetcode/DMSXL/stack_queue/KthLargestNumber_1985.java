package com.leetcode.DMSXL.stack_queue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author zyh
 * @Date 2023/3/23 14:40
 * @Version 1.0
 */
/*
* 输入：nums = ["3","6","7","10"], k = 4
* 输出："3"
* */
public class KthLargestNumber_1985 {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            if(s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });

        for(String s : nums) {
            if(pq.size() == k) {
                if(pq.peek().compareTo(s) < 0) {
                    pq.poll();
                    pq.offer(s);
                }
            }else {
                pq.offer(s);
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        System.out.println(new KthLargestNumber_1985().kthLargestNumber(new String[]{"2", "21", "12", "1"}, 3));
    }
}
