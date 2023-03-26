package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/9 16:00
 * @Version 1.0
 */

/*
* 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合
* */
public class Combine_77 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return ans;
    }

    //cur为当前遍历的数值，n为范围，k为目标个数
    private void backtrack(int cur, int n, int k) {
        // 剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if(temp.size() + (n - cur + 1) < k) {
            return;
        }

        if(temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        //选择当前位置
        temp.add(cur);
        backtrack(cur + 1, n, k);

        //回溯，不考虑当前位置
        temp.remove(temp.size() - 1);
        backtrack(cur + 1, n, k);
    }

    public static void main(String[] args) {
        System.out.println(new Combine_77().combine(5, 3));
    }
}
