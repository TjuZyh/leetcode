package com.leetcode.DMSXL_2.array;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-20
 */
/*
* 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
*   输入：nums = [3,2,2,3], val = 3
*   输出：2, nums = [2,2]
* */
public class RemoveElement_27 {
    //先排序，后二分查找出需要删除的区间，删除即可
    public int removeElement(int[] nums, int val) {
        Arrays.sort(nums);
        int[] range = new SearchRange_34().searchRange(nums, val);
        int left = range[0], right = range[1];
        int rangeCnt = right - left + 1;
        int len = nums.length;
        //2 2 3 3 4 5
        for(int i = left; i < len - rangeCnt; i++) {
            nums[i] = nums[i + rangeCnt];
        }
        System.out.println(Arrays.toString(nums));
        return len - rangeCnt;
    }
    //双指针思想，left表示当前可以覆盖的位置，right负责寻找不等于val的元素
    public int removeElement2(int[] nums, int val) {
        int left = 0, right = 0;
        while(right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
                right++;
            }else {
                right++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return left;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement_27().removeElement2(new int[]{2,3,2,4,5,3}, 3));
    }
}
