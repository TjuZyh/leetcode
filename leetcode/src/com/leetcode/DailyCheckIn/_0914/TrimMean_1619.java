package com.leetcode.DailyCheckIn._0914;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/9/14 18:55
 * @Version 1.0
 */
public class TrimMean_1619 {
    /*
    * 排序模拟
    * */
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int flag = (int)(n * 0.05);
        double cnt = 0;
        for(int i = flag ; i < n - flag ; i++){
            cnt += arr[i];
        }
        return cnt / (n - 2 * flag);
    }

    public static void main(String[] args) {
        System.out.println(new TrimMean_1619().trimMean(new int[]{6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0}));
    }
}
