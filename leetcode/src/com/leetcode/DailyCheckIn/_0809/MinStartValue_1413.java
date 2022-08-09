package com.leetcode.DailyCheckIn._0809;

/**
 * @Author zyh
 * @Date 2022/8/9 14:52
 * @Version 1.0
 */
public class MinStartValue_1413 {
    public int minStartValue(int[] nums) {
        int ans = 1;
        while(ans > 0){
            int cnt = ans;
            int flag = 1;
            for(int num : nums){
                cnt += num;
                if(cnt < 1){
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){
                return ans;
            }
            ++ans;
        }
        return 0;
    }

    /*
    * 只需要startValue的值比数组依次累加的最小值的相反数大1即可
    *   即 startValue + curAccMin >= 1
    * */
    public int minStartValue2(int[] nums) {
        //注意curAccMin的初始化，保证全是正数的时候返回1
        int accSum = 0 , curAccMin = 0;
        for(int num : nums){
            accSum += num;
            curAccMin = Math.min(curAccMin , accSum);
        }
        return -curAccMin + 1;
    }


    public static void main(String[] args) {
        System.out.println(new MinStartValue_1413().minStartValue2(new int[]{1,2,3}));
    }
}
