package com.leetcode.DailyCheckIn._0814;

import java.util.Map;

/**
 * @Author zyh
 * @Date 2022/8/14 11:51
 * @Version 1.0
 */
public class MaxScore_1422 {
    public int maxScore(String s) {
        char[] strArr = s.toCharArray();
        int len = strArr.length;
        int left = 0;
        int cnt = 0;
        for(int i = 0 ; i < len ; i++){
            if(strArr[i] == '1'){
                cnt++;
            }
        }
        int right = cnt;
        int max = 0;
        //全0 ， 注意左子串不能为空
        if(cnt == 0){
            return len - 1;
        }
        //注意要上界len-1
        //如果为len，则右子串可能为空，不满足题意
        for(int i = 0 ; i < len - 1 ; i++){
            if(strArr[i] == '0'){
                left += 1;
            }else{
                right -= 1;
            }
            max = Math.max(max , left + right);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaxScore_1422().maxScore("011101"));
    }
}
