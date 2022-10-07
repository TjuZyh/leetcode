package com.leetcode.DailyCheck._202210._1007;

/**
 * @Author zyh
 * @Date 2022/10/7 19:11
 * @Version 1.0
 */
public class MaxAscendingSum_1800 {
    public int maxAscendingSum(int[] nums) {
        int max = 0;
        for(int i = 0 ; i < nums.length - 1 ; i++){
            int cnt = nums[i];
            if(nums[i] < nums[i + 1]){
                while(i + 1 < nums.length && nums[i] < nums[i + 1]){
                    cnt += nums[i + 1];
                    i++;
                }
            }
            max = Math.max(cnt , max);
        }
        return nums.length == 1 ? nums[0] : max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxAscendingSum_1800().maxAscendingSum(new int[]{100}));
    }
}
