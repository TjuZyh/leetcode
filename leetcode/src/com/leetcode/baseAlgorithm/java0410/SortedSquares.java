package com.leetcode.baseAlgorithm.java0410;

import java.util.Arrays;

/*
* 977:给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
* */
public class SortedSquares {
    //直接排序
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = nums[i] * nums[i];
        }
        Arrays.sort(res);
        return res;
    }

    //双指针思路1
    //由于数组中的数字已经按大小排好，并且正数序列的平方原来的次序，而负数序列的平方是原来的倒序
    //解题思路：找到正负数的分界点，相当于合并两个有序序列即可
    public static int[] sortedSquares1(int[] nums){
        int len = nums.length;
        int flag = -1;
        for(int i = 0 ; i < len ; i++){
            if(nums[i] < 0){
                flag = i;
            }else {
                break;
            }
        }
        int[] res = new int[len];
        int index = 0 , i = flag , j = flag + 1;
        while(i >= 0 || j < len){
            if(i < 0){//没有负数，直接复制正数序列的平方即可
                res[index] = nums[j] * nums[j];
                j++;
            }else if(j == len){//没有正数，直接倒序复制负数的平方
                res[index] = nums[i] * nums[i];
                i--;
            }else if(nums[i] * nums[i] < nums[j] * nums[j]){//归并，小的先加入数组
                res[index] = nums[i] * nums[i];
                i--;
            }else {
                res[index] = nums[j] * nums[j];//归并
                j++;
            }
            index++;
        }
        return res;
    }

    /*
    * 双指针思想2
    *   对数组平方后，数组中的最大数值都在数组的两段，那么
    *   使用两个指针分别指向位置 0 和 n-1，每次比较两个指针对应的数，选择较大的那个逆序放入答案并移动指针。
    * */
    public static int[] sortedSquares2(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        for(int i = 0 , j = len - 1 , pos = len - 1 ; i <= j ; ){
            if(nums[i] * nums[i] > nums[j] * nums[j]){
                res[pos] = nums[i] * nums[i];
                i++;
            }else {
                res[pos] = nums[j] * nums[j];
                j--;
            }
            pos--;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {-4,-1,0,3,10};
        Arrays.stream(sortedSquares(arr)).forEach(System.out::println);
    }
}
