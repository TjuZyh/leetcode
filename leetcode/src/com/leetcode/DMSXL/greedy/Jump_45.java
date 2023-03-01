package com.leetcode.DMSXL.greedy;

/**
 * @Author zyh
 * @Date 2023/2/28 11:44
 * @Version 1.0
 */
/*
* 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度，返回到达 nums[n - 1] 的最小跳跃次数
*   输入: nums = [2,3,1,1,4]
*   输出: 2
* */
public class Jump_45 {
    //在跳的过程中，如果发现其中有可以跳到更远的位置，那么就跳到该位置，再从该位置进行下一次跳
    public int jump(int[] nums) {
        int length = nums.length;
        //利用end边界维护当前能到的最大位置，到达边界时跳跃次数+1
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        //最后一个位置无需遍历
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
