package com.leetcode.java0325;

import java.util.Arrays;

/*
* 输入整数数组 arr ，找出其中最小的 k 个数。
* */
public class GetLeastNumbers {
    public static int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res = new int[k];
        for(int i = 0 ; i < k ; i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1};
        for (int leastNumber : getLeastNumbers(arr, 2)) {
            System.out.print(leastNumber + " ");
        }
    }


}
