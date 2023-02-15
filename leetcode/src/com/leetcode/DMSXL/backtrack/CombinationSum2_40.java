package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/11 10:34
 * @Version 1.0
 */
/*
* 给定一个候选人编号的集合 candidates 和一个目标数 target ，
*   找出 candidates 中所有可以使数字和为 target 的组合
* */
public class CombinationSum2_40 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return ans;
    }


    public void backtrack(int[] candidates, int target, int sum, int begin) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = begin; i < candidates.length; i++) {
            //如果当前相同，且前一个树枝上未取过，则代表马上该树层要取，这样会出现重复，则需跳过
            //即前一个选了，当前也可以选；前一个未选，当前也不能选
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            if(sum + candidates[i] <= target) {
                used[i] = true;
                temp.add(candidates[i]);
                backtrack(candidates, target, sum + candidates[i], i + 1);
                used[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2_40().combinationSum2(new int[]{1, 1, 2, 6, 6, 7, 10}, 8));
    }
}
