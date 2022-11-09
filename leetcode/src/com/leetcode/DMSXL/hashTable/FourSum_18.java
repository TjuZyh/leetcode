package com.leetcode.DMSXL.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/11/8 12:02
 * @Version 1.0
 */
/*
* 输入：nums = [1,0,-1,0,-2,2], target = 0
* 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
* */
public class FourSum_18 {
    /*
    * 思路和三数之和一致：排序 + 双指针，不过需要O(n^3)的时间复杂度
    * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums.length < 4) {
            return ans;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if((long) nums[i] + nums[nums.length - 3] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if((long) nums[i] + nums[j] + nums[nums.length - 2] + nums[nums.length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left < right && nums[left] == nums[++left]);
                        while(left < right && nums[right] == nums[--right]);
                    }else if (sum < target){
                        while(left < right && nums[left] == nums[++left]);
                    }else {
                        while(left < right && nums[right] == nums[--right]);
                    }
                }
            }
        }
        return ans;
    }
}
