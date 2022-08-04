package com.leetcode.DailyCheckIn._0804;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/8/4 10:22 上午
 * @Version 1.0
 */
public class MinSubsequence_1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, Collections.reverseOrder());
        int cnt = 0;
        for(Integer i : integers){
            cnt += i;
        }
        int cur = 0;
        List<Integer> ans = new ArrayList<>();
        for(Integer i : integers){
            int newCnt = cnt;
            cur += i;
            if(cur > newCnt - cur){
                ans.add(i);
                return ans;
            }
            ans.add(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new MinSubsequence_1403().minSubsequence(new int[]{4,4,7,6,7}));
    }
}
