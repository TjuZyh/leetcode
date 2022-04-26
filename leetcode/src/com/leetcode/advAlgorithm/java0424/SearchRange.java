package com.leetcode.advAlgorithm.java0424;

/**
 * @Author zyh
 * @Date 2022/4/24 3:28 下午
 * @Version 1.0
 */
/*
* 34: 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
*   如果数组中不存在目标值 target，返回[-1, -1]。
* */
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int leftPos = search(nums , target , true);
        //注意这里要-1
        int rightPos = search(nums , target , false) - 1;
        if(leftPos <= rightPos && rightPos < nums.length && nums[leftPos] == target && nums[rightPos] == target){
            return new int[]{leftPos , rightPos};
        }
        return new int[]{-1 , -1};
    }

    //设定一个flag位，若为true则寻找第一个等于target的位置；否则寻找第一个大于target的位置
    public static int search(int[] nums , int target , boolean flag){
        int left = 0 , right = nums.length - 1, res = nums.length;
        while(left <= right){
            int middle = (left + right) / 2;
            if(nums[middle] > target || (flag && nums[middle] >= target)){
                right = middle - 1;
                res = middle;
            }else{
                left = middle + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10};
        int[] ints = searchRange(arr, 8);
        System.out.println(ints[0]);
        System.out.println(ints[1]);
    }
}
