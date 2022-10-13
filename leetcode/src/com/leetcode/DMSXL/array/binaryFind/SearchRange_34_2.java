package com.leetcode.DMSXL.array.binaryFind;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/10/12 20:00
 * @Version 1.0
 */
public class SearchRange_34_2 {
    /*
    * 存在三种情况：
    *   1. nums = {5,7,7,8,8,10} target = 4or12 即target不在nums区间内
    *   2. nums = {5,7,7,8,8,10} target = 6 即target在nums区间内，但无匹配
    *   3. nums = {5,7,7,8,8,10} target = 8 返回[3, 4]
    * */
    public int[] searchRange2(int[] nums, int target) {
        int indexLeft = getLeftBorder(nums, target);
        int indexRight = getRightBorder(nums, target);
        if(indexLeft != -1 && indexRight != -1){
            return new int[]{indexLeft , indexRight};
        }else {
            return new int[]{-1, -1};
        }
    }

    public int getLeftBorder(int[] nums, int target) {
        int left = 0, right = nums.length - 1, res = -1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            //[5, 7, 7, 7, 8, 8, 10] l = 0 , r = 6 , m = 3 , tar = 7
            //由于要找左边界，所以nums[m] == tars时还要继续寻找左区间，故r = m - 1
            if(nums[mid] >= target){
                //因为要寻找左边界，需要更新right，寻找左区间
                right = mid - 1;
                res = right;
            }else {
                left = mid + 1;
            }
        }
        if(res + 1 >= 0 && res + 1 <= nums.length - 1 && nums[res + 1] == target){
            return res + 1;
        }else {
            return -1;
        }
    }

    public int getRightBorder(int[] nums, int target) {
        int left = 0 , right = nums.length - 1, res = -1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] <= target){
                left = mid + 1;
                res = left;
            }else {
                right = mid - 1;
            }
        }
        if(res - 1 >= 0 && res - 1 <= nums.length - 1 && nums[res - 1] == target){
            return res - 1;
        }else {
            return -1;
        }
    }


    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new SearchRange_34_2().searchRange2(new int[]{5,6,7,7,8,8,8,10}, 8)));
        System.out.println(new SearchRange_34_2().getLeftBorder(new int[]{1}, 1));
        System.out.println(new SearchRange_34_2().getRightBorder(new int[]{1}, 1));
    }
}
