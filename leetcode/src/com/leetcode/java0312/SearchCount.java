package com.leetcode.java0312;

public class SearchCount {
    //hash但是空间复杂度太高
    public static int search(int[] nums, int target) {
        int[] hash = new int[1000];
        for(int i : nums){
            hash[i]++;
        }
        return hash[target];
    }

    //sb做法
    public static int search2(int[] nums, int target) {
        int sum = 0;
        for(int i : nums){
            if(i == target){
                sum++;
            }
        }
        return sum;
    }

    //由于题中给的数组是单调递增的，可以采用二分来做
    public static int search3(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        int count = 0;
        while(left < right){
            int middle = (left + right) / 2;
            if(nums[middle] >= target){
                right = middle;
            }else {
                left = middle + 1;
            }
        }

        while (left < nums.length && nums[left++] == target){
            count++;
        }
        return count;
    }




    public static void main(String[] args) {
        int[] arr = {5 , 7 , 7 , 8 , 8 , 10};
        System.out.println(search2(arr , 8));
    }
}
