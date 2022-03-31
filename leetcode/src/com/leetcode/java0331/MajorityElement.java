package com.leetcode.java0331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
* */
public class MajorityElement {
    /*
    * hash
    * */
    public static int majorityElement(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num , map.getOrDefault(num , 0) + 1);
        }
        int len = nums.length / 2;
        int res = 0;
        for(Integer i : map.keySet()){
            if(map.get(i) > len){
                res = i;
            }
        }
        return res;
    }
    /*
    * 数组排序法：将数组排序，数组中点元素一定为众数
    * */
    public static int majorityElement1(int[] nums){
        Arrays.sort(nums);
        return nums[nums.length / 2 - 1];
    }

    /*
    * 摩尔投票法：
    *   推论1：若记 众数 的票数为 +1 ，非众数 的票数为 −1 ，则一定有所有数字的 票数和 >0
    *   推论2：若数组的前 a 个数字的 票数和 =0 ，则 数组剩余 (n−a) 个数字的 票数和一定仍 >0 ，
    *           即后 (n-a) 个数字的 众数仍为 x
    * */
    public static int majorityElement2(int[] nums) {
        //x为当前假设的众数
        int x = 0 , votes = 0;
        for(int num : nums){
            //当票数等于0时，假设当前的数字为众数
            if(votes == 0) x = num;
            //当num = x, 票数+1 ； 当num != x , 票数 -1
            votes += num == x ? 1 : -1;
        }
        return x;
    }



    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement1(arr));
    }

}
