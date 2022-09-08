package com.leetcode.DailyCheckIn._0908;

/**
 * @Author zyh
 * @Date 2022/9/8 22:09
 * @Version 1.0
 */
public class ConstructArray_667 {
    /*
    * 思维题：
    *   1. 如果k = 1，则从1开始排序到n即可
    *   2. 如果k = n - 1，则按[1 , n , 2 , n - 1 , 3 , ...]排序
    *   3. 剩余情况可以由上面两种情况合并而来，前半部分差值为1，后半部分需要从k递减到1
    *   即通式：[1, 2, ..., n - k , n , n - k + 1 , n - 1 , ....]
    *   eg:
    *   n = 5, k = 1 [1, 2, 3, 4, 5]
    *   n = 5, k = 2 [1, 2, 3, 5, 4]
    *   n = 5, k = 3 [1, 2, 5, 3, 4]
    *   n = 5, k = 4 [1, 5, 2, 4, 3]
    * */
    public int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int idx = 0;
        //n - k之前全部顺序填入即可
        for (int i = 1; i < n - k; i++) {
            ans[idx] = i;
            ++idx;
        }
        //n - k之后一对一对填入，第一对[n - k , n]，第二对[n - k + 1 , n - 1]...
        for(int i = n - k , j = n ; i <= j ; i++ , j--){
            ans[idx] = i;
            ++idx;
            if(i != j){
                ans[idx] = j;
                ++idx;
            }
        }
        return ans;
    }
}
