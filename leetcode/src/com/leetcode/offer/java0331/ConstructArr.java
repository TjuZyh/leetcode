package com.leetcode.offer.java0331;

import java.util.Arrays;

/*
* 给定数组a，构建数组b，其中b[i]的值是数组a除了下标i以外的元素的积
* */
public class ConstructArr {
    /*
    * 表格分区
    * */
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        int tmp = 1;
        //计算下三角
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        //计算上三角
        for (int i = len - 2; i >= 0; i--) {
            tmp *= a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }

    /*
    * 将数组划分为左右两部分：时间超限
    * */
    public static int[] constructArr1(int[] a) {
        int[] b = new int[a.length];
        for(int i = 0 ; i < a.length ; i++){
            b[i] = sum(0 , i-1 ,a) * sum(i + 1 , a.length-1 ,a);
        }
        return b;
    }

    public static int sum(int i , int j , int arr[]){
        int sum = 1;
        while(i <= j){
            sum *= arr[i];
            i++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,0,4,5};
        Arrays.stream(constructArr1(arr)).forEach(System.out::println);
    }
}
