package com.leetcode.DMSXL.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/11/4 13:34
 * @Version 1.0
 */
/*
* 输入：nums = [2,7,11,15], target = 9
* 输出：[0,1]
* */
public class TwoSum_1 {
    /*
    * 暴力
    * */
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(target - cur == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    /*
    * 利用hash表存储已访问过的元素，查询会降低到O（1）
    * */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            //要先判断，否则会出现一个key用两次的情况
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum_1().twoSum2(new int[]{3, 3, 11, 15}, 6)));
    }
}
