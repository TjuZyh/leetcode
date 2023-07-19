package com.leetcode.DMSXL_2.array;

import java.util.Arrays;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-19
 */
/*
* 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
*   如果数组中不存在目标值 target，返回 [-1, -1]
* 输入：nums = [5,7,7,8,8,10], target = 8
* 输出：[3,4]
* */
public class SearchRange_34 {
    public int[] searchRange(int[] nums, int target) {
        int left = getLeftBorder(nums, target);
        int right = getRightBorder(nums, target);
        if(nums.length == 0 || left == -2 || right == -2) {
            return new int[]{-1, -1};
        }
        return new int[]{left, right};
    }

    //获取右界
    public int getRightBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int rightBorder = -2;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] <= target) {
                left = mid + 1;
                rightBorder = left;
            }else {
                right = mid - 1;
            }
        }
        if(nums[rightBorder - 1] == target) {
            return rightBorder - 1;
        }else {
            return -2;
        }
    }

    public int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int leftBorder = -2;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
                leftBorder = right;
            }
        }
        if(nums[leftBorder + 1] == target) {
            return leftBorder + 1;
        }else {
            return -2;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange_34().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
