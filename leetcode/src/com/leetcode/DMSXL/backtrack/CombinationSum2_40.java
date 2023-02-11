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
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack2(candidates, target, 0, 0);
        return ans;
    }

    //这样做会有重复序列
    public void backtrack(int[] candidates, int target, int index, int sum) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(index >= candidates.length || sum > target) {
            return;
        }

        temp.add(candidates[index]);
        backtrack(candidates, target, index + 1, sum + candidates[index]);

        temp.remove(temp.size() - 1);
        backtrack(candidates, target, index + 1, sum);
    }

    //递归形式实现，递归到当前位置需要判断一下与前面值是否相同，相同则一定会出现重复情况，直接continue考虑下一个位置即可
    //注意要在排序后回溯
    public void backtrack2(int[] candidates, int target, int sum, int begin) {
        if(sum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = begin; i < candidates.length; i++) {
            if(i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(candidates[i] + sum > target) {
                break;
            }else {
                temp.add(candidates[i]);
                backtrack2(candidates, target, sum + candidates[i], i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2_40().combinationSum2(new int[]{1, 1, 2, 6, 6, 7, 10}, 8));
    }
}
