package com.leetcode.DMSXL.array.binaryFind;

/**
 * @Author zyh
 * @Date 2022/10/13 20:55
 * @Version 1.0
 */
public class IsPerfectSquare_367 {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while(left <= right){
            int mid = (right - left) / 2 + left;
            //注意java除法会自动向下取整，需要转成double处理
            if(mid == (double) num / mid){
                return true;
            }else if(mid < (double) num / mid){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare_367().isPerfectSquare(5));
    }
}
