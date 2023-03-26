package com.leetcode.DMSXL_2.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/26 16:54
 * @Version 1.0
 */
/*
* 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合
*   输入：n = 4, k = 2
*   输出：[[2,4], [3,4], [2,3], [1,2], [1,3], [1,4]]
* */
public class Combine_77 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, k, n);
        return ans;
    }

    public void backtrack(int cur, int k, int n) {
        if(temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(temp.size() + (n - cur  + 1) < k) {
            return;
        }

        if(cur > n) {
            return;
        }

        temp.add(cur);
        backtrack(cur + 1, k, n);

        temp.remove(temp.size() - 1);
        backtrack(cur + 1, k, n);
    }

    public static void main(String[] args) {
        System.out.println(new Combine_77().combine(4, 2));
    }
}
