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
public class FindMaxForm_474_2 {
    /*
    * 暴力枚举出全部的子集可能，然后依次判断子集是否满足要求即可
    * */
    int maxLen = Integer.MIN_VALUE;
    List<String> temp = new ArrayList<>();
    public int findMaxForm2(String[] strs, int m, int n) {
        backtrack(strs, 0, m, n);
        return maxLen;
    }

    public void backtrack(String[] strs, int index, int m, int n) {
        if(index == strs.length) {
            //System.out.println(temp);
            int[] zoNum = getZONum(temp);
            if(temp.size() >= maxLen) {
                if(zoNum[0] <= m && zoNum[1] <= n) {
                    maxLen = Math.max(maxLen, temp.size());
                }
            }
            return;
        }
        temp.add(strs[index]);
        backtrack(strs, index + 1, m, n);

        temp.remove(temp.size() - 1);
        backtrack(strs, index + 1, m, n);
    }

    public int[] getZONum(List<String> list) {
        int zeroNum = 0, oneNum = 0;
        for(String str : list) {
            char[] chars = str.toCharArray();
            for(char ch : chars) {
                if(ch == '0') {
                    zeroNum++;
                }else {
                    oneNum++;
                }
            }
        }
        return new int[]{zeroNum, oneNum};
    }







    public static void main(String[] args) {
        System.out.println(new FindMaxForm_474_2().findMaxForm2(new String[]{"10","0001","111001","1","0"}, 3, 3));
    }
}
