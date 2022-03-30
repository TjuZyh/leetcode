package com.leetcode.java0330;

import java.util.*;

/*
* 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。
* 要求时间复杂度是O(n)，空间复杂度是O(1)。
* */
public class SingleNumbers {
    /*
    * 用map和暴力会让复杂度变为O(n^2), 不可取
    * */
    public static int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int[] res = new int[(nums.length - 2) / 2];
        int k = 0;
        int[] arr = new int[2];
        int w = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int oldLen = set.size();
            set.add(nums[i]);
            if(oldLen == set.size()){
                res[k++] = nums[i];
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < res.length ; j++){
                if(nums[i] == res[j]){
                    continue;
                }else {
                    arr[w++] = nums[i];
                }
            }
        }
        return arr;
    }

    /*
    * 异或操作两个性质：
    *   1. 两个相同的数异或为0
    *   2. 0异或任何数等于任何数
    * */
    public static int[] singleNumbers1(int[] nums) {
        int x = 0 , y = 0 , n = 0 , m = 1;
        //遍历异或，值为 x^y
        for(int num : nums){
            n ^= num;
        }
        //找到 x^y 为1的二进制位，用m存储
        while((n & m) == 0){
            m <<= 1;
        }
        //遍历nums数组进行分组
        for(int num : nums){
            //通过与m与运算，可以将数组分为两组，x和y也必定存在于不同的两组
            if((m & num) != 0) {
                x ^= num;
            }else {
                y ^= num;
            }
        }
        return new int[]{x , y};

    }

    public static void main(String[] args) {
        int[] arr = {4 , 1 , 4 , 3 , 5 , 5};
        Arrays.stream(singleNumbers(arr)).forEach(System.out::println);
    }
}
