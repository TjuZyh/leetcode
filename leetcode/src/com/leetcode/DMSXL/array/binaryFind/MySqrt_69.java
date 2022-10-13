package com.leetcode.DMSXL.array.binaryFind;

/**
 * @Author zyh
 * @Date 2022/10/13 20:23
 * @Version 1.0
 */
public class MySqrt_69 {
    /*
    * 二分查找：对因子k进行查找即可，递增查找太暴力，可以通过二分加快查找效率
    *   下界可以从0开始，上界可以粗略的从x开始
    * 该题相当于寻找插入位置二分的题，所以直接返回right 或 left-1即可
    * */
    public int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right){
            int mid = (right - left) / 2 + left;
            if((long)mid * mid <= x){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(new MySqrt_69().mySqrt(8));
    }
}
