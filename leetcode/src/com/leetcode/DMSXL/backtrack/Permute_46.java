package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/13 22:01
 * @Version 1.0
 */
/*
* 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列
* */
public class Permute_46 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums.length == 0) return ans;
        backtrack(nums, temp);
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> temp) {
        if(temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            //System.out.println("递归前：" + temp);
            backtrack(nums, temp);
            temp.remove(temp.size() - 1);
            //System.out.println("回溯：" + temp);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Permute_46().permute(new int[]{1, 2, 3}));
    }


}
