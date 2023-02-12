package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/12 15:49
 * @Version 1.0
 */
/*
* 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）
* */
public class SubsetsWithDup_90 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack2(nums, 0);
        return ans;
    }

    //递归方式
    //遇到不选择当前重复数时，选择下一个重复数会导致子集重复，所以如果未选当前数，应该跳过后面重复的数
    //[1,2,2,2,3]
    //如果未选第二个位置的2，则递归时应该从3开始
    public void backtrack(int[] nums, int index) {
        if(nums.length == index) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        //选择当前位置
        temp.add(nums[index]);
        backtrack(nums, index + 1);

        //如果不选当前位置时，且下一个元素和当前相等，则一定会重
        temp.remove(temp.size() - 1);
        //跳过后面相同的数
        while(index < nums.length - 1 && nums[index] == nums[index + 1]) {
            index++;
        }
        backtrack(nums, index + 1);
    }

    //迭代方式
    public void backtrack2(int[] nums, int index) {
        ans.add(new ArrayList<>(temp));
        for(int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i - 1]) continue;
            temp.add(nums[i]);
            backtrack(nums, index + 1);
            temp.remove(temp.size() - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup_90().subsetsWithDup(new int[]{1, 2, 2, 2, 3}));
    }
}
