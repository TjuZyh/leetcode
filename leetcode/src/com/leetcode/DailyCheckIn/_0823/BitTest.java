package com.leetcode.DailyCheckIn._0823;

/**
 * @Author zyh
 * @Date 2022/8/23 16:00
 * @Version 1.0
 */
public class BitTest {
    public static void main(String[] args) {
        int num = 12;
        int reverse = ((1 << 4) - 1) ^ num;
        System.out.println(num + " -> " + reverse);

        int[] arr = {1,0,1,0,1};
        int merge = 0;
        for(int i = 0 ; i < arr.length ; i++){
            merge |= (arr[i] << i);
        }
        System.out.println(merge);

        int ones = Integer.bitCount(num);
        System.out.println(ones);
    }
}
