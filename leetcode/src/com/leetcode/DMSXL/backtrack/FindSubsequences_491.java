package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/12 20:18
 * @Version 1.0
 */
/*
* 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素
* */
public class FindSubsequences_491 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtrack2(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int index) {
        if(index == nums.length) {
            if(temp.size() >= 2) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }

        if(temp.size() == 0 || nums[index] >= temp.get(temp.size() - 1)){
            temp.add(nums[index]);
            backtrack(nums, index + 1);
            temp.remove(temp.size() - 1);
        }

        // 对于[4,6,7,7]，后面的两个7，出现重复有两种情况，选择前面的7和选择后面的7
        // 如果前面选了7，则后面的7一定要选
        // 6,7结果中7是后面的7
        if(temp.size() == 0 || nums[index] != temp.get(temp.size() - 1)) {
            backtrack(nums, index + 1);
        }
    }

    private void backtrack2(int[] nums, int start) {
        if (temp.size() > 1) {
            //这里不用return，因为需要继续记录后续节点
            ans.add(new ArrayList<>(temp));
        }

        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if (!temp.isEmpty() && nums[i] < temp.get(temp.size() - 1) || (used[nums[i] + 100] == 1)) {
                continue;
            }
            used[nums[i] + 100] = 1;
            temp.add(nums[i]);
            backtrack2(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new FindSubsequences_491().findSubsequences(new int[]{4,7,6,7}));
    }
}
