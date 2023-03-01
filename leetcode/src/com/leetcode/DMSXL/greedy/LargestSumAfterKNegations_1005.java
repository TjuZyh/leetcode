package com.leetcode.DMSXL.greedy;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/1 14:49
 * @Version 1.0
 */
/*
* 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
*   重复这个过程恰好 k 次
* 输入：nums = [4,2,3], k = 1
* 输出：5
* */
public class LargestSumAfterKNegations_1005 {
    //对数组排序，优先对负数进行反转，如果没有负数了就选取最小的正数反转
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        //System.out.println(Arrays.toString(nums));
        int cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                cnt++;
            }
        }
        //System.out.println(cnt);
        if(cnt >= k) {
            for(int i = 0; i < k; i++) {
                nums[i] = -nums[i];
            }
            return Arrays.stream(nums).sum();
        }else {
            for(int i = 0; i < cnt; i++) {
                nums[i] = - nums[i];
            }
            Arrays.sort(nums);
            boolean isEven = ((k - cnt) % 2) == 0;
            //System.out.println(isEven);
            if(isEven) {
                return Arrays.stream(nums).sum();
            }else {
                return Arrays.stream(nums).sum() - nums[0] * 2;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new LargestSumAfterKNegations_1005().largestSumAfterKNegations(new int[]{3,-1,0,2}, 1));
    }
}
