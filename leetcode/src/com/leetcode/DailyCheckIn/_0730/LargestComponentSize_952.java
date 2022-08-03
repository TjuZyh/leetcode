package com.leetcode.DailyCheckIn._0730;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/7/30 5:36 下午
 * @Version 1.0
 */
public class LargestComponentSize_952 {
    public static int largestComponentSize(int[] nums) {
        int[] array = new int[nums.length];
        for(int i = 0 ; i < array.length ; i++){
            array[i] = i;
        }
        //O^3 不超时才怪 可以利用类似于归并的想法将复杂度降低到n^2logn
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = i + 1 ; j < nums.length ; j++){
                if(isGY(nums[i] , nums[j])){
                    union(array , i , j);
                }
            }
        }
        for(int i = 0 ; i < array.length ; i++){
            int j = i;
            while(array[j] != j){
                j = array[j];
            }
            array[i] = j;
        }
        int max = -1;
        int[] cnt = new int[array.length];
        for(int i = 0 ; i < array.length ; i++){
            cnt[array[i]]++;
        }
        for(int i = 0 ; i < cnt.length ; i++){
            max = Math.max(max , cnt[i]);
        }
        return max;
    }

    public static int findRoot(int[] array , int cur){
        while(cur != array[cur]){
            cur = array[cur];
        }
        return cur;
    }

    public static void union(int[] array , int x , int y){
        int f1 = findRoot(array , x);
        int f2 = findRoot(array , y);
        if(f1 != f2){
            array[f2] = f1;
        }
    }


    public static boolean isGY(int x , int y){
        for(int i = 1 ; i <= Math.min(x , y) ; i++){
            if((i != 1) && (x % i == 0) && (y % i == 0)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(largestComponentSize(new int[]{4,6,15,35}));
    }
}
