package com.leetcode.DMSXL.greedy;

/**
 * @Author zyh
 * @Date 2023/2/28 11:28
 * @Version 1.0
 */
/*
* 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
*   判断你是否能够到达最后一个下标
* 输入：nums = [2,3,1,1,4]
* 输出：true
* */
public class CanJump_55 {
    //跳到当前位置，比较当前位置的数和剩余步数大小，选取大的继续遍历
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int curJump = nums[0];
        //[0,1]
        if(nums.length > 1 && nums[0] == 0) {
            return false;
        }
        for(int i = 1; i < n; i++) {
            curJump--;
            curJump = Math.max(nums[i], curJump);
            //[2,0,0]
            if(curJump <= 0 && i != n - 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CanJump_55().canJump(new int[]{2, 0, 0}));
    }
}

