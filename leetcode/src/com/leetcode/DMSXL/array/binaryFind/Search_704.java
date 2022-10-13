package com.leetcode.DMSXL.array.binaryFind;

/**
 * @Author zyh
 * @Date 2022/10/10 22:01
 * @Version 1.0
 */
/*
* 二分查找前提：
*   1. 数组为有序数组
*   2. 数组中无重复数据
* 输入: nums = [-1,0,3,5,9,12], target = 9
* 输出: 4
* */
public class Search_704 {
    /*
    * 二分版本1: [right, left]
    * */
    public int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
    /*
     * 二分版本2: [right, left)
     * */
    public int search2(int[] nums, int target) {
        int left = 0 , right = nums.length;
        while (left < right){
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Search_704().search2(new int[]{-1,0,3,5,9,12}, 2));
    }
}
