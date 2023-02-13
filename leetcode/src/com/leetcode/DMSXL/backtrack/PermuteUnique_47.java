package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/13 22:24
 * @Version 1.0
 */
/*
* 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列
* */
public class PermuteUnique_47 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] visit;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums.length == 0) return ans;
        Arrays.sort(nums);
        visit = new boolean[nums.length];
        backtrack(nums, temp);
        return ans;
    }

    public void backtrack(int[] nums, List<Integer> temp) {
        if(nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            //上一位置选择了，那么可以继续选；如果未选择，那么当前也不能选
            //因为在同一层，前面的遍历已经选择前面的数了
            //看一下代码随想录的图解，结合当前层和上一层理解
            if(visit[i] || (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1])) {
                continue;
            }
            temp.add(nums[i]);
            visit[i] = true;
            backtrack(nums, temp);
            visit[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique_47().permuteUnique(new int[]{1, 1, 2}));
    }
}
