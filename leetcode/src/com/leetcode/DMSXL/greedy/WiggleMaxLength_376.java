package com.leetcode.DMSXL.greedy;

/**
 * @Author zyh
 * @Date 2023/2/16 20:34
 * @Version 1.0
 */

/*
* 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列
*   给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度
* 输入：nums = [1,17,5,10,13,15,10,5,16,8]
* 输出：7
 * */
public class WiggleMaxLength_376 {
    //只需要寻找摆动节点即可，如果当前的差值与其前面的差值同号，则跳过继续向后寻找
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if(n < 2) {
            return n;
        }
        int curDiff = 0, preDiff = 0;
        int ans = 1;
        for(int i = 1; i < n; i++) {
            curDiff = nums[i] - nums[i - 1];
            if((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                //System.out.println(nums[i]);
                ans++;
                preDiff = curDiff;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        new WiggleMaxLength_376().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8});
    }
}
