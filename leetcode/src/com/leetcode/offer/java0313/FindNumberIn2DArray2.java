package com.leetcode.offer.java0313;

public class FindNumberIn2DArray2 {
    /*
    * 解题思路：由于二维数组行列都是单调递增的，所以可以从右上角开始遍历数组
    *   当前位置数据小于target，row++；当前位置数据大于target，col--
    *
    * */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix .length == 0){
            return false;
        }

        int m = matrix.length , n = matrix[0].length;
        int row = 0 , col = n - 1;
        while(row < m && col >= 0){
            if(matrix[row][col] > target){
                col--;
            }else if(matrix[row][col] < target){
                row++;
            }else{
                return true;
            }
        }
        return false;
    }
}
