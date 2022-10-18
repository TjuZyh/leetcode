package com.leetcode.DMSXL.array.removeElement;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/10/16 22:13
 * @Version 1.0
 */
/*
* 编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
* 输入: nums = [0,1,0,3,12]
* 输出: [1,3,12,0,0]
* */
public class MoveZeroes_283 {
    /*
    * 直接覆盖 + 剩余补0
    */
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                nums[left] = nums[right];
                left++;
            }
            right++;
        }
        for(int i = left; i < nums.length ; i++){
            nums[i] = 0;
        }
    }

    /*
    * 0与非0交换
    * */
    public void moveZeroes2(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        new MoveZeroes_283().moveZeroes(new int[]{0});
    }
}
