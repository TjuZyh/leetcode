package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/9 19:45
 * @Version 1.0
 */
/*
* 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
*   1. 只使用数字1到9
*   2. 每个数字 最多使用一次
* 返回 所有可能的有效组合的列表
*
* 输入: k = 3, n = 9
* 输出: [[1,2,6], [1,3,5], [2,3,4]]
* */
public class CombinationSum3_216 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, 0, n, 1);
        return ans;
    }

    public void backtrack(int k, int sum, int n, int cur) {
        //剪枝：如果当前剩余的数无法构成k个数
        if(temp.size() + (9 - cur + 1) < k) {
            return;
        }

        if(temp.size() == k) {
            if(sum == n) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        //剪枝：如果当前cur已经大于9 或者 已经超过k个数了
        if(cur > 9 || temp.size() > k) {
            return;
        }

        temp.add(cur);
        sum += cur;
        backtrack(k, sum, n, cur + 1);

        temp.remove(temp.size() - 1);
        backtrack(k, sum - cur, n, cur + 1);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3_216().combinationSum3(9, 45));
    }

}








