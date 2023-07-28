package com.leetcode.DMSXL_2.array;

import java.util.Arrays;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-28
 */
/*
* 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序
*   输入：nums = [-4,-1,0,3,10]
*   输出：[0,1,9,16,100]
* */
public class SortedSquares_977 {
    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int[] ans = new int[nums.length];
        for(int i = ans.length - 1; i >= 0; i--) {
            int leftNum = nums[left] * nums[left], rightNum = nums[right] * nums[right];
            if (leftNum > rightNum) {
                ans[i] = leftNum;
                left++;
            }else {
                ans[i] = rightNum;
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortedSquares_977().sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }
}
