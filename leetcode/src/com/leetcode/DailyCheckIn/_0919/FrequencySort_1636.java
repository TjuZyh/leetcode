package com.leetcode.DailyCheckIn._0919;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/9/19 18:04
 * @Version 1.0
 */
public class FrequencySort_1636 {
    /*
    * 自定义排序
    * */
    public int[] frequencySort(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Map<Integer , Integer> map = new HashMap<>();
        for(int i : nums){
            list.add(i);
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        Collections.sort(list , (l1 , l2) -> {
            return map.get(l1) != map.get(l2) ? map.get(l1) - map.get(l2) : l2 - l1;
        });
        for(int i = 0 ; i < list.size() ; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FrequencySort_1636().frequencySort(new int[]{2,3,1,3,2})));
    }
}
