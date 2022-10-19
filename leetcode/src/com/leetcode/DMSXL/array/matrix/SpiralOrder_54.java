package com.leetcode.DMSXL.array.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/10/19 20:57
 * @Version 1.0
 */
/*
* 按照顺时针螺旋顺序 ，返回矩阵中的所有元素
* 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
* 输出：[1,2,3,6,9,8,7,4,5]
*   1 2 3
*   4 5 6
*   7 8 9
* */
public class SpiralOrder_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1;
        int cnt = matrix.length * matrix[0].length;
        while(cnt > 0){
            //注意长方形的情况，需要在内循环加上cnt > 0的条件
            for(int i = left; i <= right && cnt > 0; i++) {
                ans.add(matrix[top][i]);
                cnt--;
            }
            top++;
            for(int i = top; i <= bottom && cnt > 0; i++){
                ans.add(matrix[i][right]);
                cnt--;
            }
            right--;
            for(int i = right; i >= left && cnt > 0; i--){
                ans.add(matrix[bottom][i]);
                cnt--;
            }
            bottom--;
            for(int i = bottom; i >= top && cnt > 0; i--){
                ans.add(matrix[i][left]);
                cnt--;
            }
            left++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix2 = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(new SpiralOrder_54().spiralOrder(matrix1));
    }
}
