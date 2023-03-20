package com.leetcode.DMSXL.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/20 17:10
 * @Version 1.0
 */
/*
* 给你一个二进制字符串数组 strs 和两个整数 m 和 n
*   请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1
*
* 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
* 输出：4
* */
public class FindMaxForm_474 {
    /*
    * 可以将本题看做是01背包的变种，即字符串数组中的每个字符串元素视为物品，物品中的01个数视为重量
    *   m和n视作两个维度的背包重量限制
    * 1. dp[i][j]: 最多有i个0和j个1的最大子集长度为dp[i][j]
    * 2. dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
    * 3. 均默认为0即可
    * 4. 物品正序遍历，背包空间倒序遍历（两个维度，先遍历m(0)，后遍历n(1)）
    * */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int zeroNum, oneNum;
        for(String str : strs) {
            zeroNum = 0;
            oneNum = 0;
            for(char ch : str.toCharArray()) {
                if(ch == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
            for(int i = m; i >= zeroNum; i--) {
                for(int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
            System.out.println("zeroNum: " + zeroNum + " oneNum: " + oneNum);
            System.out.println(Arrays.deepToString(dp));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(new FindMaxForm_474().findMaxForm(new String[]{"10","0001","111001","1","0"}, 3, 3));
    }
}
