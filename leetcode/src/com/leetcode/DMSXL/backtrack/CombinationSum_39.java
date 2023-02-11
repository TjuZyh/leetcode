package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/10 22:45
 * @Version 1.0
 */
/*
* 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，
* 找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回
*   输入：candidates = [2,3,6,7], target = 7
*   输出：[[2,2,3],[7]]
* */
public class CombinationSum_39 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack2(candidates, target, 0, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int index, int sum) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index >= candidates.length) {
            return;
        }
        //不选择当前位置
        backtrack(candidates, target, index + 1, sum);

        //选择当前位置
        if(sum + candidates[index] <= target) {
            temp.add(candidates[index]);
            backtrack(candidates, target, index, sum + candidates[index]);
            temp.remove(temp.size() - 1);
        }
    }

    public void backtrack2(int[] candidates, int target, int index, int sum) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index >= candidates.length) {
            return;
        }
        if(sum > target) {
            return;
        }
        //选择当前位置，之后可以继续选择该位置
        temp.add(candidates[index]);
        backtrack(candidates, target, index, sum + candidates[index]);

        //不选择当前位置，即跳过该位置
        temp.remove(temp.size() - 1);
        backtrack(candidates, target, index + 1, sum);
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum_39().combinationSum(new int[]{2, 3, 6, 7}, 7));
    }


}
