package com.leetcode.DMSXL_2.hashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-01
 */
/*
* 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
*   输入：nums = [2,7,11,15], target = 9
*   输出：[0,1]
* */
public class TwoSum_1 {
    /*
    * 使用hash的时机：
    *   1. 查询一个数是否出现在集合中
    *   2. 查询一个数是否出现过
    * */
    public int[] twoSum(int[] nums, int target) {
        //map<num, index>
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int find = target - curNum;
            if(map.containsKey(find)) {
                return new int[]{i, map.get(find)};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(new TwoSum_1().twoSum(new int[]{3, 2, 4}, 6)));
    }
}
