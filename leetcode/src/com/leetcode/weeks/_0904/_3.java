package com.leetcode.weeks._0904;

/**
 * @Author zyh
 * @Date 2022/9/4 10:23
 * @Version 1.0
 */
// nums = [1,3,8,48,10]
public class _3 {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int cur = getWith(nums, i, j);
                max = Math.max(max , cur);
            }
        }
        return max;
    }

    public int getWith(int[] nums , int start , int end){
        for(int i = start ; i <= end ; i++){
            for(int j = i + 1 ; j <= end ; j++){
                if((nums[i] & nums[j]) != 0){
                    return 1;
                }
            }
        }
        return end - start + 1;
    }
    public static void main(String[] args) {
        System.out.println(new _3().getWith(new int[]{1, 3, 8, 48 , 10} , 1, 3));
        System.out.println(new _3().longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
    }
}
