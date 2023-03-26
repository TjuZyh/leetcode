package com.leetcode.DMSXL_2.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/3/26 18:45
 * @Version 1.0
 */
/*
* 返回数组中全部子数组
*   输入：nums = [1,2,3]
*   输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
* */
public class Subsets_78 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int index) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if(index > nums.length) {
            return;
        }

        temp.add(nums[index]);
        backtrack(nums, index + 1);

        temp.remove(temp.size() - 1);
        backtrack(nums, index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Subsets_78().subsets(new int[]{1, 2, 3}));
    }
}
