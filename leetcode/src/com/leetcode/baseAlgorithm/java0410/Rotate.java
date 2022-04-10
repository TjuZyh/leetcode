package com.leetcode.baseAlgorithm.java0410;

import java.util.Arrays;

/*
* 189: 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数
* */
public class Rotate {
    /*
    * 使用额外的数组空间
    * */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] res = new int[len];
        //j : 处理k > arr.length的情况
        int i = 0 , j = len - (k % len);
        int index = 0;
        for(int m = j ; m < len ; m++){
            res[index] = nums[m];
            index++;
        }
        for(int n = i ; n < j ; n++){
            res[index] = nums[n];
            index++;
        }
        System.arraycopy(res , 0 , nums , 0 , len);
    }

    /*
    * 数组翻转
    *   先将所有元素翻转，这样尾部的 k mod n 个元素就被移至数组头部，
    *   再翻转 [0, k mod n-1] 区间的元素和 [k mod n, n-1]区间的元素即能得到最后的答案
    *   eg : 1234567 n = 7 k = 3
    *   翻转：7654321
    *   翻转前 k % n - 1 : 5674321
    *   翻转后 k % n : 5671234
    * */
    public static void rotate1(int[] nums, int k){
        k %= nums.length;
        reverse(nums , 0 , nums.length - 1);
        reverse(nums , 0 , k - 1);
        reverse(nums , k , nums.length - 1);
    }

    public static void reverse(int[] nums , int start , int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1 , 2 , 3, 4,5,6,7};
        rotate(arr , 3);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
