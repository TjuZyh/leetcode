package com.leetcode.DMSXL.stack_queue;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/11/20 23:55
 * @Version 1.0
 */
/*
* 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素
*   输入: nums = [1,1,1,2,2,3], k = 2
*   输出: [1,2]
* */
public class TopKFrequent_347 {
    /*
    * 先用hash表记录键出现的个数，后排序寻找前k个即可
    * */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<int[]> list = new ArrayList<>();
        for(Integer i : map.keySet()) {
            list.add(new int[]{i, map.get(i)});
        }
        //瓶颈所在，对list排序相当于排序了全部数字，时间复杂度O(nlogn)
        //可以利用小顶堆只维护k个元素即可
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        int[] ans = new int[k];
        int index = 0;
        for(int[] ints : list) {
            if(index == k) break;
            ans[index] = ints[0];
            index++;
        }
        return ans;
    }

    /*
    * hash表 + 小顶堆
    *   小顶堆只维护k个元素，当判断时只判定当前元素的出现个数与堆顶元素的个数，判定是否出入堆
    * 可以将时间复杂度降低到O(nlogk)
    * */
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(Integer i : map.keySet()) {
            int curNum = i, count = map.get(i);
            if(pq.size() == k) {
                if(pq.peek()[1] < count) {
                    pq.poll();
                    pq.offer(new int[]{curNum, count});
                }
            }else {
                pq.offer(new int[]{curNum, count});
            }
        }

        int[] ans = new int[k];
        for(int i = 0; i < k; i++) {
            ans[i] = pq.poll()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TopKFrequent_347().topKFrequent2(new int[]{1, 1, 1, 2, 2, 3}, 2)));
    }
}
