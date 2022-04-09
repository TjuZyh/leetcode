package com.leetcode.offer.java0313;

/*
* 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
* 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
* */
public class FindNumberIn2DArray {
    //将二维化为一维解答
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int[] arr : matrix){
            if(findNumberInArray(arr , target)){
                return true;
            }
        }
        return false;
    }

    public static boolean findNumberInArray(int[] arr , int target){
        int left = 0 , right = arr.length - 1;
        while(left <= right){
            int middle = (left + right) / 2;
            if(arr[middle] < target){
                left = middle + 1;
            }else if(arr[middle] > target) {
                right = middle - 1;
            }else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2,   5,  8, 12, 19};
        System.out.println(findNumberInArray(arr, 14));
    }
}
