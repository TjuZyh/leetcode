package com.leetcode.baseAlgorithm.java0411;

import java.util.Arrays;

/*
* 167：给你一个下标从 1 开始的整数数组numbers ，该数组已按 非递减顺序排列 ，
*   请你从数组中找出满足相加之和等于目标数target 的两个数。
*   如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
* */
public class TwoSum {
    /*
    * 暴力 : 时间超限
    * */
    public static int[] twoSum(int[] numbers, int target) {
        for(int i = 0 ; i < numbers.length ; i++){
            for(int j = i + 1 ; j < numbers.length ; j++){
                if(numbers[i] + numbers[j] == target){
                    return new int[]{i + 1 , j + 1};
                }
            }
        }
        return new int[0];
    }

    /*
    * 二分查找：固定一个数，二分查找其后面的序列即可
    * */
    public int[] twoSum2(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            int low = i + 1, high = numbers.length - 1;
            while (low <= high) {
                int mid = (high - low) / 2 + low;
                if (numbers[mid] == target - numbers[i]) {
                    return new int[]{i + 1, mid + 1};
                } else if (numbers[mid] > target - numbers[i]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }

    /*
    * 双指针：设立头尾两个指针，
    *   如果加和大于target，则尾指针左移；加和小于target，则头指针右移
    * */
    public int[] twoSum3(int[] numbers, int target) {
        int head = 0 , end = numbers.length - 1;
        while(head < end){
            int sum = numbers[head] + numbers[end];
            if(sum == target){
                return new int[]{head + 1 , end + 1};
            }else if(sum < target){
                ++head;
            }else {
                --end;
            }
        }
        return new int[0];
    }



    public static void main(String[] args) {
        int[] arr = {2,3, 4};
        Arrays.stream(twoSum(arr, 6)).forEach(System.out::println);
    }
}
