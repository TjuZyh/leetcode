package com.leetcode.DMSXL.greedy;

import java.util.Arrays;

/**
 * @Author zyh
 * @Date 2023/2/16 20:17
 * @Version 1.0
 */
/*
* 尽可能满足越多数量的孩子，并输出这个最大数值
*   g[i]为胃口值，s[i]为饼干尺寸
* 输入: g = [1,2], s = [1,2,3]
* 输出: 2
* */
public class FindContentChildren_455 {
    //对数组排序，优先满足小胃口
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0, i = 0;
        while(i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++;
                ans++;
            }
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new FindContentChildren_455().findContentChildren(new int[]{1, 1,3,4,5}, new int[]{1,2,3,1,1}));
    }
}
