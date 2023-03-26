package com.leetcode.DMSXL_2.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/26 17:06
 * @Version 1.0
 */
/*
* 满足target的组合，元素可以重复使用
*   输入：candidates = [2,3,6,7], target = 7
*   输出：[[2,2,3],[7]]
* */
public class CombinationSum_39 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack2(candidates, target, 0, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int curSum, int index) {
        if(curSum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if(curSum > target || index >= candidates.length) {
            return;
        }

        temp.add(candidates[index]);
        //注意：由于元素可以选多次，所以可以继续取当前位置
        backtrack(candidates, target, curSum + candidates[index], index);

        temp.remove(temp.size() - 1);
        backtrack(candidates, target, curSum, index + 1);
    }

    public void backtrack2(int[] candidates, int target, int curSum, int index) {
        if(target == curSum) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index >= candidates.length || curSum > target) {
            return;
        }
        //外层for循环控制树横向遍历
        for(int i = index; i < candidates.length; i++) {
            //处理当前节点
            temp.add(candidates[i]);
            //控制树的纵向遍历，注意元素可以重复取，可以继续处理i位置
            backtrack(candidates, target, curSum + candidates[i], i);
            //撤销处理的节点
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum_39().combinationSum(new int[]{2, 3, 6}, 6));
    }



}
