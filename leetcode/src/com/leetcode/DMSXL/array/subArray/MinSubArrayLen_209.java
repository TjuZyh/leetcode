package com.leetcode.DMSXL.array.subArray;

/**
 * @Author zyh
 * @Date 2022/10/18 19:29
 * @Version 1.0
 */
/*
* 返回满足条件（子数组元素之和 >= target）的最短子数组
* 输入：target = 7, nums = [2,3,1,2,4,3]
* 输出：2
* */
public class MinSubArrayLen_209 {
    /*
    * 暴力: 时间超限 O(n^2)
    * */
    public int minSubArrayLen(int target, int[] nums) {
        int min = nums.length;
        boolean flag = false;
        for(int i = 0 ; i < nums.length ; i++){
            int subArrayLen = getSubArrayLen(target, nums, i);
            if(subArrayLen != -1){
                flag = true;
                min = Math.min(min , subArrayLen);
            }
        }
        return flag ? min : 0;
    }

    public int getSubArrayLen(int target, int[] nums, int index){
        int start = index;
        while(target > 0){
            if(index > nums.length - 1){
                return -1;
            }
            target -= nums[index];
            index++;
        }
        return target <= 0 ? index - start : -1;
    }

    /*
    * 滑动窗口：利用双指针确定一个滑动窗口
    *   当子数组元素之和大于或等于target后，更新最短数组长度，并滑动窗口
    * */
    public int minSubArrayLen2(int target, int[] nums) {
        int left = 0, right = 0, cnt = 0, ans = Integer.MAX_VALUE;
        while(right < nums.length){
            cnt += nums[right];
            //注意下面的判断要while不可以为if，if的话会丢解
            while(cnt >= target){
                ans = Math.min(ans , right - left + 1);
                cnt -= nums[left];
                ++left;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubArrayLen_209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));

        System.out.println(new MinSubArrayLen_209().getSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}, 2));
    }


}
