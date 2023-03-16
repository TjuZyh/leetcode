package com.leetcode.DMSXL.dynamicProgramming;

/**
 * @Author zyh
 * @Date 2023/3/16 23:51
 * @Version 1.0
 */
/*
* 每次选择两个数，若相等则均变为0，不等则小的为0，大的变为 大 - 小，迭代下去，求最后一个数的最小值
*   输入：stones = [2,7,4,1,8,1]
*   输出：1
* */
public class LastStoneWeightII_1049 {
    /*
    * 对于两个数互相比较，可以上升到两组数互相比较，由于最终要求剩余最小值，那么就是要求这两组数尽量一致
    *   和分割等和子集方式一样，将其转化为01背包问题解决，最终比较dp[target]与sum - dp[target]的差值即可
    * */
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int i : stones) {
            sum += i;
        }
        int target = sum / 2;
        int[] dp = new int[target + 1];
        for(int i = 0; i < stones.length; i++) {
            for(int j = target; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        return sum - dp[target] - dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new LastStoneWeightII_1049().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
