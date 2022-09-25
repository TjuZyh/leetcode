package com.leetcode.DailyCheckIn._0925;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/9/25 12:30
 * @Version 1.0
 */
public class RotatedDigits_788 {
    /*
    * 简单模拟
    * */
    public int rotatedDigits(int n) {
        int cnt = 0;
        for(int i = 1 ; i <= n ; i++){
            if(isGoodNum(i)){
                cnt++;
            }
        }
        return cnt;
    }

    public boolean isGoodNum(int n){
        boolean flag = false;
        while(n > 0){
            int cur = n % 10;
            if(cur == 2 || cur == 5 || cur == 6 || cur == 9){
                flag = true;
            }else if(cur == 3 || cur == 4 || cur == 7){
                return false;
            }
            n = n / 10;
        }
        return flag;
    }

    public static void main(String[] args) {
        System.out.println(new RotatedDigits_788().rotatedDigits(857));
    }
}
