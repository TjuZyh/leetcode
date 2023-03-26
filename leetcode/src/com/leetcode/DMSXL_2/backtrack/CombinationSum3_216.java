package com.leetcode.DMSXL_2.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/26 18:32
 * @Version 1.0
 */
/*
* 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件
*   输入: k = 3, n = 7
*   输出: [[1,2,4]]
* */
public class CombinationSum3_216 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k ,n, 1, 0);
        return ans;
    }

    public void backtrack(int k, int n, int cur, int sum) {
        if(sum == n && temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(sum > n || cur > 9 || temp.size() > k) {
            return;
        }

        temp.add(cur);
        backtrack(k, n, cur + 1, sum + cur);

        temp.remove(temp.size() - 1);
        backtrack(k, n, cur + 1, sum);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3_216().combinationSum3(3, 9));
    }


}
