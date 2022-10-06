package com.leetcode.DailyCheck._202210._1006;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2022/10/6 14:37
 * @Version 1.0
 */
public class ThreeEqualParts_927 {
    /*
    * 首先统计数组中1的个数，如果不是1的三倍则不成立
    *   后锁定第一组、第二组以及第三组首次出现1的位置first、second、third
    *   最后一组为[third, len - 1]，最后一组的长度为len - third
    *   则第一组为[first , first + len - 1]，第二组为[second , second + len - 1]，第三组为[third , third + len - 1]
    *   如果三组均相等，则分割点为[first + len - 1 , second + len]
    *   注意，判断的时候没有考虑前导0的问题，但是确定分割点时已经考虑到了前导0
    * */
    public int[] threeEqualParts(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return new int[]{-1, -1};
        }
        if (sum == 0) {
            return new int[]{0, 2};
        }

        int partial = sum / 3;
        int first = 0, second = 0, third = 0, cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == partial) {
                    second = i;
                } else if (cur == 2 * partial) {
                    third = i;
                }
                cur++;
            }
        }

        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (third + i < arr.length) {
                if (arr[first + i] != arr[second + i] || arr[first + i] != arr[third + i]) {
                    return new int[]{-1, -1};
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ThreeEqualParts_927().threeEqualParts(new int[]{0, 1, 0, 1, 0, 1, 0})));
    }
}
