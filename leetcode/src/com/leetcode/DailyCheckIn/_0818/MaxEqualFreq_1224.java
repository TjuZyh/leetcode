package com.leetcode.DailyCheckIn._0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author zyh
 * @Date 2022/8/18 15:16
 * @Version 1.0
 */
public class MaxEqualFreq_1224 {
    /*
    * 哈希表计数类问题：
    *   首先利用map统计出字符出现的个数（key为num[i],value为出现的个数）
    *   后只需从后遍历数组，依次删掉末尾key值，重新统计个数，符合题意即可
    *   存在三种情况：
    *       1. 有一个字符只出现一次，剩下字符个数保持一致，eg：5 5 1 5（出现的个数）
    *       2. 存在max和max-1个个数，max只能出现一次，eg：2 3 2 2
    *       3. 其实属于第一种，所有字符只出现1次，eg：1 1 1 1
    *   对于字符的统计问题，可以通过set集进行统计
    * */
    public int maxEqualFreq(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i : nums){
            //初始化
            map.putIfAbsent(i, 0);
            map.put(i , map.get(i) + 1);
        }

        for(int i = nums.length - 1 ; i >= 0 ; i--){
            Set<Integer> set = new HashSet<>();
            //个数为1的字符只能出现一次
            int flag = 0;
            //字符个数的最大值只能出现一次
            int flag2 = 0;
            int max = Integer.MIN_VALUE;
            for(Integer key : map.keySet()){
                if(map.get(key) == 1){
                    ++flag;
                }
                set.add(map.get(key));
                max = Math.max(map.get(key) , max);
            }
            for(Integer key : map.keySet()){
                if(map.get(key) == max){
                    ++flag2;
                }
            }

            //第一种情况
            if(set.size() == 2 && flag == 1 && set.contains(1)){
                return i + 1;
            }
            //第二种情况
            if(set.size() == 2 && flag2 == 1 && isOne(set)) {
                return i + 1;
            }
            //第三种情况
            if(set.size() == 1 && set.contains(1)){
                return nums.length;
            }

            if(map.get(nums[i]) != null){
                map.put(nums[i] , map.get(nums[i]) - 1);
            }
            if(map.get(nums[i]) == 0){
                map.remove(nums[i]);
            }

        }
        return -1;
    }

    //set集中最大最小的值是否差1，用于判断第二种情况
    public static boolean isOne(Set<Integer> set){
        int flag = 1;
        int cnt = 0;
        for(Integer s : set){
            if(flag == 1){
                cnt += s;
                ++flag;
            }else{
                cnt -= s;
            }

        }
        return cnt == 1 || cnt == -1;
    }

    public static void main(String[] args) {
        System.out.println(new MaxEqualFreq_1224().maxEqualFreq(new int[]{1,2}));

    }
}
