package com.leetcode.DMSXL_2.array;

import java.util.Arrays;

/**
 * @author ZhaoYiHan <ZhaoYiHan03@kuaishou.com>
 * Created on 2023-07-28
 */
/*
* 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix
*   输入：n = 3
*   输出：[[1,2,3],[8,9,4],[7,6,5]]
* */
public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n) {
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        int cnt = 0;
        int[][] ans = new int[n][n];
        while(cnt < n * n) {
            for(int i = left; i <= right; i++) ans[top][i] = ++cnt;
            top++;
            for(int i = top; i <= bottom; i++) ans[i][right] = ++cnt;
            right--;
            for(int i = right; i >= left; i--) ans[bottom][i] = ++cnt;
            bottom--;
            for(int i = bottom; i >= top; i--) ans[i][left] = ++cnt;
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new GenerateMatrix_59().generateMatrix(4)));
    }
}
