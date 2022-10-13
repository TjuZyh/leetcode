package com.leetcode.DMSXL.array.binaryFind;

/**
 * @Author zyh
 * @Date 2022/10/11 21:58
 * @Version 1.0
 */
/*
* 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
*   如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
* */
public class SearchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        //return right + 1;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(new SearchInsert_35().searchInsert(arr, 2));
    }
}
