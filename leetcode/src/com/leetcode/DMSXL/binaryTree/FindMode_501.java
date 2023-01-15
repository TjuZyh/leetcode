package com.leetcode.DMSXL.binaryTree;

import com.leetcode.TreeNode;

import java.util.*;

/**
 * @Author zyh
 * @Date 2022/12/15 11:42
 * @Version 1.0
 */
/*
* 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数
* */
public class FindMode_501 {
    /*
    * 利用map记录出现的次数，后扫描得出结果，空间复杂度O(n)
    * */
    Map<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        map = new HashMap<>();
        inOrder(root);
        int maxCnt = 0;
        for(Integer i : map.keySet()) {
            maxCnt = Math.max(maxCnt, map.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer i : map.keySet()) {
            if(map.get(i) == maxCnt) {
                ans.add(i);
            }
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < res.length ; i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void inOrder(TreeNode node) {
        if(node == null) return;
        inOrder(node.left);
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        inOrder(node.right);
    }

    /*
    * 边遍历边记录，节省空间
    * */
    List<Integer> ans = new ArrayList<>();
    int base, count, maxCount;
    public int[] findMode2(TreeNode root) {
        dfs(root);
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public void dfs(TreeNode node) {
        if(node == null) return;
        dfs(node.left);
        update(node.val);
        dfs(node.right);
    }

    public void update(int x) {
        if(x == base) {
            count++;
        }else {
            count = 1;
            base = x;
        }
        if(count == maxCount) {
            ans.add(base);
        }
        if(count > maxCount) {
            maxCount = count;
            ans.clear();
            ans.add(base);
        }
    }
}
