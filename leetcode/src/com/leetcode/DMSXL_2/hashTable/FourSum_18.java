package com.leetcode.DMSXL_2.hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-08-02
 */
/*
* 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
*   找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
* 输入：nums = [1,0,-1,0,-2,2], target = 0
* 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
* */
public class FourSum_18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        //利用双指针的方式将O(n^4)降到O(n^3)
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for(int first = 0; first < nums.length; first++) {
            if(nums[first] > 0 && nums[first] > target) {
                return ans;
            }
            if(first > 0 && nums[first - 1] == nums[first]) {
                continue;
            }
            for(int second = first + 1; second < nums.length; second++) {

                if(nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = second + 1, fourth = nums.length - 1;
                while(third < fourth) {
                    int sum = nums[first] + nums[second] + nums[third] + nums[fourth];
                    if(sum < target) {
                        third++;
                    }else if(sum > target) {
                        fourth--;
                    }else {
                        ans.add(Arrays.asList(nums[first], nums[second], nums[third], nums[fourth]));
                        while(third < fourth && nums[third + 1] == nums[third]) third++;
                        while(third < fourth && nums[fourth - 1] == nums[fourth]) fourth--;
                        third++;
                        fourth--;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FourSum_18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
