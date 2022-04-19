package com.leetcode.baseAlgorithm.java0419;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/4/19 8:03 下午
 * @Version 1.0
 */
/*
* 46 : 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
* */
public class Permute {
    /*
    * 回溯：通过探索所有可能的候选解来找出所有的解的算法，如果候选解被确认不是一个解（或者至少不是最后一个解），
    *       回溯算法会通过在上一步进行一些变化抛弃该解，即回溯并且再次尝试
    *
    * 将题目给定的 n 个数的数组 nums 划分成左右两个部分，左边的表示已经填过的数，右边表示待填的数，
    *   在回溯的时候只要动态维护这个数组即可
    *
    * 交换方式维护数组：通过交换的方式来填数可以降低空间复杂度
    * */
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> temp = new ArrayList<>();

    public static List<List<Integer>> permute(int[] nums) {
        for(int num : nums){
            temp.add(num);
        }
        int n = nums.length;
        backtrack(n , 0);
        return res;
    }

    public static void backtrack(int len , int cur){
        if(cur == len){
            res.add(new ArrayList<>(temp));
        }
        for(int i = cur ; i < len ; i++){
            //动态维护数组
            Collections.swap(temp , cur , i);
            //继续递归填下一个数
            backtrack(len , cur + 1);
            //回溯
            Collections.swap(temp , cur , i);
        }
    }

    /*
    * 回溯：创建visited数组，记录已经填过的位置
    * */
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int[] visited = new int[nums.length];
        List<Integer> temp = new ArrayList<>();
        backtrace1(visited , nums , temp , res);
        return res;
    }

    public void backtrace1(int[] visited , int[] nums , List<Integer> temp , List<List<Integer>> res){
        if(temp.size() == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(visited[i] == 1) continue;
            visited[i] = 1;
            temp.add(nums[i]);
            backtrace1(visited , nums , temp , res);
            //回溯
            visited[i] = 0;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        permute(new int[]{1,2}).stream().forEach(s -> s.stream().forEach(System.out::println));
    }
}
