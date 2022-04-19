package com.leetcode.baseAlgorithm.java0419;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zyh
 * @Date 2022/4/19 4:38 下午
 * @Version 1.0
 */
/*
* 77： 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
*   你可以按 任何顺序 返回答案。
* */
public class Combine {
    /*
    * 递归枚举
    * */
    static List<Integer>  temp = new ArrayList<>();
    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        dfs(1 , n , k);
        return res;

    }

    public static void dfs(int cur , int n , int k){
        //剪枝：temp 长度加上区间 [cur, n] 的长度小于 k，不可能构造出长度为 k 的 temp
        if(temp.size() + (n - cur + 1) < k){
            return;
        }
        //记录合法的答案
        if(temp.size() == k){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        //可以删除，重复判断
        /*if(cur == n + 1){
            return;
        }*/
        //考虑选择当前位置
        temp.add(cur);
        dfs(cur + 1 , n , k);
        //回溯
        temp.remove(temp.size() - 1);
        //考虑不选择当前位置
        dfs(cur + 1 , n , k);
    }

    public static void main(String[] args) {
        combine(4 , 2).stream().forEach(s -> s.stream().forEach(System.out::println));
    }
}
