package com.leetcode.offer.java0321;

import java.util.ArrayList;

public class Exchange {
    /*
    * 创建两个数组存储奇数和偶数
    * */
    public static int[] exchange(int[] nums) {
        ArrayList<Integer> evenList = new ArrayList<>();
        ArrayList<Integer> oddList = new ArrayList<>();
        for(int i : nums){
            if(i % 2 == 0){
                evenList.add(i);
            }else {
                oddList.add(i);
            }
        }
        oddList.addAll(evenList);
        int[] res = new int[oddList.size()];
        for(int i = 0 ; i < res.length ; i++){
            res[i] = oddList.get(i);
        }
        return res;
    }
    /*
    * 利用双指针i，j，分别从数组首以及尾部进行遍历；
    *   i指针从左到右查找偶数；
    *   j指正从右到左查找奇数；
    *   交换两个指针上的数
    * */
    public static int[] exchange1(int[] nums) {
        int i = 0 , j = nums.length - 1 , temp;
        while(i < j){
            while (i < j && (nums[i] % 2 == 1)) i++;
            while (i < j && (nums[j] % 2 == 0)) j--;
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = {1 , 2, 3, 4};
        for(int i : exchange1(arr)){
            System.out.print(i + " ");
        }
    }
}
