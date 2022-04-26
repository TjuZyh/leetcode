package com.leetcode.advAlgorithm.java0424;

/**
 * @Author zyh
 * @Date 2022/4/25 2:12 下午
 * @Version 1.0
 */
/*
* 74： 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
*   每行中的整数从左到右按升序排列。
*   每行的第一个整数大于前一行的最后一个整数。
* */
public class SearchMatrix {
    //对于二维数组可以将其转换为一维数据来解决
    //  可以对matrix[0][j]，也就是第一列进行二分查找，查找出最后一个不大于target的元素
    //  后对该行再次进行二分查找即可
    public static boolean searchMatrix(int[][] matrix, int target) {
        int lowIndex = searchMatrixByColumn(matrix , target);
        if(lowIndex < 0){
            return false;
        }
        return searchMatrixByRow(matrix[lowIndex] , target);
    }

    //对第一列进行二分，查询最后一个不大于target的值
    public static int searchMatrixByColumn(int[][] matrix , int target) {
        int low = -1 , high = matrix.length - 1;
        while(low < high){
            int mid = (high - low + 1) / 2 + low;
            if(matrix[mid][0] <= target){
                low = mid;
            }else{
                high = mid - 1;
            }
        }
        return low;
    }

    //按行进行二分
    public static boolean searchMatrixByRow(int[] row , int target) {
        int low = 0 , high = row.length - 1;
        while(low <= high){
            int mid = (high - low) / 2 + low;
            if(row[mid] == target){
                return true;
            }else if(row[mid] > target){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(searchMatrix(arr , 20));
        System.out.println(searchMatrixByColumn(arr, 20));
    }
}
