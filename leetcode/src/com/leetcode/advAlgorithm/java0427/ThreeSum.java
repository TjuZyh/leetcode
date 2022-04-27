package com.leetcode.advAlgorithm.java0427;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/4/27 8:26 下午
 * @Version 1.0
 */
/*
* 15: 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
*   请你找出所有和为 0 且不重复的三元组。
* */
public class ThreeSum {
    /*
    * 思路：O(n^2)
    *   1.排序
    *   2.固定一个值target，双指针方式寻找nums[i] + nums[j] = -target即可
    * */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null && nums.length <= 2){
            return res;
        }
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length - 2 ; i++){
            if(nums[i] > 0) break;
            //去重
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            //固定一个值nums[i], 查找后两个加和等于-nums[i]的元素
            int target = -nums[i];
            int left = i + 1 , right = nums.length - 1;
            while(left < right){
                if(nums[left] + nums[right] == target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i] , nums[left] , nums[right])));
                    //需要继续移动指针，可能还有其他的两个元素加和等于target
                    ++left ; --right;
                    //去重
                    while(left < right && nums[left] == nums[left - 1]) ++left;
                    while(left < right && nums[right] == nums[right + 1]) --right;
                }else if(nums[left] + nums[right] < target){
                    ++left;
                }else{
                    --right;
                }
            }
        }
        return res;
    }
}
