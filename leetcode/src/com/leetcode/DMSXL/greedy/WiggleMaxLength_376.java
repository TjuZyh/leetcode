package com.leetcode.DMSXL.greedy;

/**
 * @Author zyh
 * @Date 2023/2/16 20:34
 * @Version 1.0
 */

public class WiggleMaxLength_376 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return n;
        }
        int prevDiff = nums[1] - nums[0];
        int res = prevDiff == 0 ? 1 : 2;
        for(int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if((diff > 0 && prevDiff <= 0) || (diff < 0 && prevDiff >= 0)) {
                res++;
                prevDiff = diff;
            }
        }
        return res;
    }
}
