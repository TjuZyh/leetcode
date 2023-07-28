package com.leetcode.DMSXL_2.array;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-28
 */
/*
* 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0
*   输入：target = 7, nums = [2,3,1,2,4,3]
*   输出：2
*   解释：子数组 [4,3] 是该条件下的长度最小的子数组
* */
public class MinSubArrayLen_209 {
    //滑动窗口：先利用right不断扩大窗口大小，直到满足条件后，再利用left缩小窗口(满足条件的前提下)，寻找最小子数组
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0, ans = Integer.MAX_VALUE;
        int curSum = 0;
        while(right < nums.length) {
            curSum += nums[right];
            while(curSum >= target) {
                ans = Math.min(right - left + 1, ans);
                curSum -= nums[left];
                left++;
            }
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen_209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 7, 1}));
    }
}
