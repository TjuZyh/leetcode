package com.leetcode.DailyCheckIn._0922;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/9/22 14:00
 * @Version 1.0
 */
/*
* arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
* 条件：pieces中数字不重复
* */
public class CanFormArray_1640 {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for(int i = 0 ; i < arr.length ; ){
            int[] subArr = getSubArr(arr[i] , pieces);
            if(subArr[0] == -1){
                return false;
            }
            for(int j = 0 ; j < subArr.length ; j++){
                if(subArr[j] == arr[i]){
                    i++;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] getSubArr(int num , int[][] pieces){
        for(int[] i : pieces){
            if(i[0] == num){
                return i;
            }
        }
        return new int[]{-1};
    }


    public static void main(String[] args) {
        System.out.println(new CanFormArray_1640().canFormArray(new int[]{1, 1, 1, 2}, new int[][]{{1}, {1, 2}, {1}}));
    }
}
