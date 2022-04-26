package com.leetcode.advAlgorithm.java0424;

/**
 * @Author zyh
 * @Date 2022/4/25 1:54 下午
 * @Version 1.0
 */
/*
* 33：整数数组 nums 按升序排列，数组中的值 互不相同
* 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * */
public class Search {
    /*
    * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
    *   此时有序部分用二分法查找；无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。
    *   依次循环直到找到有序列，后用二分解决
    * */
    public static int search(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return -1;
        }
        if(len == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0 , right = len - 1;
        while(left <= right){
            int middle = (left + right) / 2;
            if(nums[middle] == target){
                return middle;
            }
            //左半边有序的情况
            if(nums[0] <= nums[middle]){
                //target存在于左边有序列中
                if(nums[0] <= target && target < nums[middle]){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }else{//右半边有序的情况
                if(nums[middle] < target && target <= nums[len - 1]){
                    left = middle + 1;
                }else{
                    right = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr, 1));
    }
}
