package com.leetcode.DMSXL.array.binaryFind;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/10/12 20:00
 * @Version 1.0
 */
public class SearchRange_34 {
    /*
    * 先二分查到target的一个随机位置（如果有，没有直接返回[-1,-1]）,后设立双指针寻找左右界即可
    * */
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums , target);
        if(index == -1){
            return new int[]{-1 , -1};
        }
        int left = index , right = index;
        while(left - 1 >= 0 && nums[left - 1] == target){
            left--;
        }
        while(right + 1 <= nums.length - 1 && nums[right + 1] == target){
            right++;
        }
        return new int[]{left, right};
    }

    public int binarySearch(int[] nums , int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] > target){
                right = mid - 1;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    /*
    * 存在三种情况：
    *   1. nums = {5,7,7,8,8,10} target = 4or12 即target不在nums区间内
    *   2. nums = {5,7,7,8,8,10} target = 6 即target在nums区间内，但无匹配
    *   3. nums = {5,7,7,8,8,10} target = 8 返回[3, 4]
    * */
    public int[] searchRange2(int[] nums, int target) {
        int indexLeft = getLeftBorder(nums, target);
        int indexRight = getRightBorder(nums, target);
        //情况1：寻找左右界一定会有一个界为-2
        if(indexLeft == -2 || indexRight == -2){
            return new int[]{-1, -1};
        }
        //情况3
        if(nums[indexLeft + 1] == nums[indexRight - 1]){
            return new int[]{indexLeft + 1, indexRight - 1};
        }else { // 情况2：未找到目标值
            return new int[]{-1, -1};
        }
    }

    public int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = -2;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] >= target){
                //因为要寻找左边界，需要更新right，寻找左区间
                right = mid - 1;
                res = right;
            }else {
                left = mid + 1;
            }
        }
        return res;
    }

    public int getRightBorder(int[] nums, int target) {
        int left = 0 , right = nums.length - 1, res = -2;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] <= target){
                left = mid + 1;
                res = left;
            }else {
                right = mid - 1;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SearchRange_34().searchRange2(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(new SearchRange_34().getLeftBorder(new int[]{5,7,7,8,8,10}, 4));
        System.out.println(new SearchRange_34().getRightBorder(new int[]{5,7,7,8,8,10}, 4));
    }
}
