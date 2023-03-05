package com.leetcode.DMSXL.greedy;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/3/5 10:04
 * @Version 1.0
 */
/*
* n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分，要求
*   每个孩子至少分配到 1 个糖果
*   相邻两个孩子评分更高的孩子会获得更多的糖果。
* 计算并返回需要准备的 最少糖果数目
*   输入：ratings = [1,0,2]
*   输出：5
* */
public class Candy_135 {
    //思路两次遍历，后取最大值
    //两次贪心取局部最优，后进行汇总推出全局最优
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        //1. 先初始化数组均为1
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        //2. 从左到右遍历，如果右边比左边大，就要比左边的大1
        //只能保证右边获得的糖比左边的大，但是左边比右边大的情况考虑不到
        for(int i = 0; i < len - 1; i++) {
            if(ratings[i + 1] > ratings[i]) {
                left[i + 1] = left[i] + 1;
            }
        }
        //3. 从右到左遍历，如果左边比右边大，就要比右边的大1
        for(int i = len - 1; i > 0; i--) {
            if(ratings[i - 1] > ratings[i]) {
                right[i - 1] = right[i] + 1;
            }
        }
        int sum = 0;
        //4. 取最大值
        for(int i = 0; i < len; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Candy_135().candy(new int[]{1, 0, 2}));
    }
}
