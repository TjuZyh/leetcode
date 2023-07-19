package com.leetcode.DMSXL_2.array;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-19
 */
/*
* 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
*   输入: nums = [1,3,5,6], target = 7
*   输出: 4
* */
public class SearchInsert_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        /*
        * 下面两种方式都可以，因为边界条件判断的是left <= right
        * 所以在跳出边界时，mid在 left - 1位置，寻找下一个插入位置，那么就是left即可
        * */
        return left;
        //return right + 1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInsert_35().searchInsert(new int[]{1, 3, 5, 6}, 7));
    }
}
