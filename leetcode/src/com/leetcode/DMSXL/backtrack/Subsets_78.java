package com.leetcode.DMSXL.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2023/2/12 15:10
 * @Version 1.0
 */

/*
* 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
*   输入：nums = [1,2,3]
*   输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
* */
public class Subsets_78 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int index) {
        if(index == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[index]);
        backtrack(nums, index + 1);

        temp.remove(temp.size() - 1);
        backtrack(nums, index + 1);
    }

    //迭代，不断将当前位置的值，加入到已经遍历好的子集中
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //[]
        ans.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++) {
            int len = ans.size();
            for(int j = 0; j < len; j++) {
                //[]
                List<Integer> cloneList = new ArrayList<>(ans.get(j));
                //[1]
                cloneList.add(nums[i]);
                //[] [1]
                ans.add(cloneList);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(new Subsets_78().subsets(new int[]{1, 2, 3}));
    }


}
