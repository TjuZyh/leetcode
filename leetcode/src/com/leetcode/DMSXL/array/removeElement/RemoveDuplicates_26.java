package com.leetcode.DMSXL.array.removeElement;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/10/15 16:37
 * @Version 1.0
 */
/*
* 数组去重，空间复杂度O(1)
* 输入：nums = [0,0,1,1,1,2,2,3,3,4]
* 输出：5, nums = [0,1,2,3,4]
* */
public class RemoveDuplicates_26 {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != nums[left]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates_26().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
