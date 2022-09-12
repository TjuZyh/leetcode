package com.leetcode.DailyCheckIn._0912;

/**
 * @Author zyh
 * @Date 2022/9/12 22:13
 * @Version 1.0
 */
public class SpecialArray_1608 {
    public int specialArray(int[] nums) {
        int ans = 1;
        while (ans <= nums.length){
            int cnt = 0;
            for(int i : nums){
                if(i >= ans){
                    cnt++;
                }
                if(cnt > ans){
                    break;
                }
            }
            if(cnt == ans){
                return ans;
            }else {
                ans++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SpecialArray_1608().specialArray(new int[]{3,6,7,7,0}));
    }
}
