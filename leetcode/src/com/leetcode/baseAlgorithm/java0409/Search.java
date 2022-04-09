package com.leetcode.baseAlgorithm.java0409;

/*
* 704:给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，
*   写一个函数搜索nums 中的 target，如果目标值存在返回下标，否则返回 -1。
* */
public class Search {
    public static int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while(left <= right){
            int middle = (left + right) / 2;
            if(nums[middle] > target){
                right = middle - 1;
            }else if(nums[middle] < target){
                left = middle + 1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        System.out.println(search(arr , 1));
    }
}
