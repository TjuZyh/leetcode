package com.leetcode.offer.java0324;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
* 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。
* A 不能视为 14。
* */
public class IsStraight {
    /*
    * 满足以下条件则视为顺子：
    *   1. 除大小王，无重复的牌
    *   2. 除大小王，最大牌 - 最小牌 < 5
    * */
    public static boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int min = Integer.MAX_VALUE , max = 0;
        for(int num : nums){
            if(num == 0) continue;
            max = Math.max(num , max);
            min = Math.min(num , min);
            if(set.contains(num)) return false;
            set.add(num);
        }
        return max - min < 5;
    }

    /*
    * 排序 + 判重
    * */
    public static boolean isStraight1(int[] nums) {
        int jokerCnt = 0;
        Arrays.sort(nums);
        for(int i = 0 ; i < 4 ; i++){
            if(nums[i] == 0) jokerCnt++;
            else if(nums[i] == nums[i + 1]) return false;
        }
        //排序后nums[jokerCnt]即为最小值，jokerCnt位置为最小值所在的位置
        return nums[4] - nums[jokerCnt] < 5;
    }

    public static void main(String[] args) {
        int[] nums = {0 , 0 , 1 , 2 , 5};
        System.out.println(isStraight(nums));
    }
}
