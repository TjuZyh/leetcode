package com.leetcode.DMSXL.array.removeElement;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/10/17 17:38
 * @Version 1.0
 */
/*
* 输入：nums = [-4,-1,0,3,10]
* 输出：[0,1,9,16,100]
* 时间：O(n) 空间O(1)
* */
public class SortedSquares_977 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int left = 0, right = nums.length - 1, pos = nums.length - 1;
        while(pos >= 0){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                ans[pos] = nums[left] * nums[left];
                left++;
            }else {
                ans[pos] = nums[right] * nums[right];
                right--;
            }
            pos--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortedSquares_977().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
