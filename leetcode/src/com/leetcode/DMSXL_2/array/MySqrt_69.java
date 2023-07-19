package com.leetcode.DMSXL_2.array;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-19
 */
/*
* 你一个非负整数 x ，计算并返回 x 的 算术平方根 。由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去
*   输入：x = 8
*   输出：2
* */
public class MySqrt_69 {
    public int mySqrt(int x) {
        int left = 0, right = x, ans = 0;
        while(left <= right) {
            int root = (right - left) / 2 + left;
            if(root * root <= x) {
                ans = left;
                left = root + 1;
            }else {
                right = root - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt_69().mySqrt(16));
    }
}
