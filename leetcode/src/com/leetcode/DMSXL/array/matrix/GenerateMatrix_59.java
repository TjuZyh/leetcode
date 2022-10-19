package com.leetcode.DMSXL.array.matrix;

/**
 * @Author zyh
 * @Date 2022/10/19 20:09
 * @Version 1.0
 */
/*
* 生成螺旋矩阵
*   输入：n = 3
*   输出：[[1,2,3],[8,9,4],[7,6,5]]
*   1 2 3
*   8 9 4
*   7 6 5
* */
public class GenerateMatrix_59 {
    public int[][] generateMatrix(int n) {
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int[][] matrix = new int[n][n];
        int num = 1, target = n * n;
        while(num <= target){
            for(int i = left; i <= right; i++) matrix[top][i] = num++;
            top++;
            for(int i = top; i <= bottom; i++) matrix[i][right] = num++;
            right--;
            for(int i = right; i >= left; i--) matrix[bottom][i] = num++;
            bottom--;
            for(int i = bottom; i >= top; i--) matrix[i][left] = num++;
            left++;
        }
        return matrix;
    }
}
