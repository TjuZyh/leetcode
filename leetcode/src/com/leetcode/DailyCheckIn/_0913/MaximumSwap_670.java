package com.leetcode.DailyCheckIn._0913;

/**
 * @Author zyh
 * @Date 2022/9/13 18:44
 * @Version 1.0
 */
public class MaximumSwap_670 {
    /*
    * 暴力 : 数字范围为 0 - 10^8，即8位，最多交换28次
    *   2736 -> 7236
    * */
    public int maximumSwap(int num) {
        char[] charArr = String.valueOf(num).toCharArray();
        int n = charArr.length;
        int max = num;
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                swap(i , j , charArr);
                max = Math.max(max , Integer.parseInt(new String(charArr)));
                swap(i , j , charArr);
            }
        }
        return max;
    }

    public void swap(int i , int j , char[] nums){
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int a = 1234567891;
        System.out.println(a);
    }


}
