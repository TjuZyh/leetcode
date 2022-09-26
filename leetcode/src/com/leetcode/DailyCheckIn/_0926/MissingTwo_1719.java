package com.leetcode.DailyCheckIn._0926;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/9/26 19:16
 * @Version 1.0
 */
/*
* 给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字
* 要求：在 O(N) 时间内只用 O(1) 的空间找到它们
*   不能排序、不能创建额外空间
*
* 输入: [2,3]
* 输出: [1,4]
* */
public class MissingTwo_1719 {
    /*
    * 模拟：算法思路
    *   1. 缺失两个数，并且最终为1-n，则缺失的两个数的和为 (nums.length + 2 + 1) * (nums.length + 2) / 2
    *   2. 缺失两个数不重复，必在sum/2的两边，并且有且仅有一个数在sum/2的左边
    *       那么就可以求出 1 到 sum/2的总和，然后遍历数组，依次减去小于sum/2的数，剩余的数即为两个数中较小的一个数
    * */
    public int[] missingTwo(int[] nums) {
        int n = nums.length + 2 , cur = (n + 1) * n / 2;
        for(int num : nums) cur -= num;
        //sum为两个数的和，两个数一定分布在t = sum/2两边
        int sum = cur , t = sum / 2;
        cur = (t + 1) * t / 2;
        for(int num : nums){
            if(num <= t) cur -= num;
        }
        return new int[]{cur , sum - cur};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MissingTwo_1719().missingTwo(new int[]{1, 3, 4, 6, 8, 5, 9})));
    }
}
