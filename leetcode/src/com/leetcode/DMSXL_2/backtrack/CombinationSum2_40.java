package com.leetcode.DMSXL_2.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/26 17:58
 * @Version 1.0
 */
/*
* 元素存在重复，每个元素只能取一次
*   输入: candidates = [2,5,2,1,2], target = 5,
*   输出:[[1,2,2], [5]]
* */
public class CombinationSum2_40 {
    //创建used数组记录元素使用情况
    boolean[] used;
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        Arrays.fill(used, false);
        backtrack(candidates, target, 0, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int curSum, int index) {
        if(curSum == target) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index >= candidates.length || target < curSum) {
            return;
        }
        for(int i = index; i < candidates.length; i++) {
            //元素相同时，前一个元素未取，则当前元素也不能取，否则会出现重复（前一个元素取在其纵向遍历的时候已经包括了两个元素都取的情况了）
            if(i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            temp.add(candidates[i]);
            backtrack(candidates, target, curSum + candidates[i], i + 1);
            used[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum2_40().combinationSum2(new int[]{1, 1, 2}, 3));
    }

}
